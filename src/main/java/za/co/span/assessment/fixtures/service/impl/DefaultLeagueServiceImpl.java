package za.co.span.assessment.fixtures.service.impl;

import leaguerankingservice.consume.api.DefaultFixturesControllerApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import za.co.span.assessment.fixtures.pojo.LoginModel;
import za.co.span.assessment.fixtures.pojo.ResultModel;
import za.co.span.assessment.fixtures.pojo.Team;
import za.co.span.assessment.fixtures.service.DefaultLeagueResultsService;
import za.co.span.assessment.fixtures.utils.mapper.InitializeLoginModel;
import za.co.span.assessment.fixtures.utils.mapper.InitializeResultModel;
import za.co.span.assessment.fixtures.utils.mapper.TeamMapper;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultLeagueServiceImpl implements DefaultLeagueResultsService, DefaultViewLeagueRankingTableService {
    private static final Logger log = LoggerFactory.getLogger(DefaultLeagueServiceImpl.class);

    private DefaultFixturesControllerApi defaultFixturesControllerApi;

    @Value("${league.ranking.service.basepath}")
    private String basePath;

    @PostConstruct
    private void setupApiClient() {
        defaultFixturesControllerApi = new DefaultFixturesControllerApi();
        defaultFixturesControllerApi.getApiClient().setBasePath(basePath);
    }

    @Override
    public void submitResult(LoginModel loginModel, ResultModel resultModel) {
        setAuthorization(loginModel);

        try {
            defaultFixturesControllerApi.captureResultUsingPOST(resultModel.getResult());
        } catch (HttpStatusCodeException httpStatusCodeException) {
            log.error("Failed to execute GET on {}, due to {}", basePath + "/fixtures/result/{result}", httpStatusCodeException.getStatusCode());
            if (httpStatusCodeException.getRawStatusCode() == 401 || httpStatusCodeException.getRawStatusCode() == 403) {
                InitializeLoginModel.initialize(loginModel);
            }
        } catch (Exception exception) {
            log.error("Failed to execute GET on {}, due to {}", basePath + "/fixtures/result/{result}", exception.getCause().getMessage());
        }
        InitializeResultModel.initialize(resultModel);
    }

    @Override
    public List<Team> viewRankingTable(LoginModel loginModel) {
        setAuthorization(loginModel);
        List<Team> teamList = new ArrayList<>();
        try {
            teamList = TeamMapper.INSTANCE.mapToPojo(defaultFixturesControllerApi.rankingUsingGET());
        } catch (HttpStatusCodeException httpStatusCodeException) {
            log.error("Failed to execute GET on {}, due to {}", basePath + "/fixtures/ranking", httpStatusCodeException.getStatusCode());
            if (httpStatusCodeException.getRawStatusCode() == 401 || httpStatusCodeException.getRawStatusCode() == 403) {
                InitializeLoginModel.initialize(loginModel);
            }
        } catch (Exception exception) {
            log.error("Failed to execute GET on {}, due to {}", basePath + "/fixtures/ranking", exception.getCause().getMessage());
        }
        return teamList;
    }

    private void setAuthorization(LoginModel loginModel) {
        defaultFixturesControllerApi.getApiClient().addDefaultHeader("Authorization", "Basic " + loginModel.getBasicAuth());
    }
}
