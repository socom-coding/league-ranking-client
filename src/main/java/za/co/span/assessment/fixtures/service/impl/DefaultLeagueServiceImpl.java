package za.co.span.assessment.fixtures.service.impl;

import leaguerankingservice.consume.api.DefaultFixturesControllerApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import za.co.span.assessment.fixtures.pojo.LoginModel;
import za.co.span.assessment.fixtures.pojo.SubmitResultModel;
import za.co.span.assessment.fixtures.pojo.Team;
import za.co.span.assessment.fixtures.service.DefaultLeagueService;
import za.co.span.assessment.fixtures.utils.mapper.TeamMapper;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class DefaultLeagueServiceImpl implements DefaultLeagueService {
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
    public void submitResult(SubmitResultModel submitResultModel) {
        setAuthorization(submitResultModel.getLoginModel());
        defaultFixturesControllerApi.captureResultUsingPOST(submitResultModel.getResultModel().getResult());
    }

    @Override
    public List<Team> viewRankingTable(LoginModel loginModel) {
        setAuthorization(loginModel);

        List<Team> teamList = TeamMapper.INSTANCE.mapToPojo(defaultFixturesControllerApi.rankingUsingGET());
        return teamList;
    }

    private void setAuthorization(LoginModel loginModel) {
        defaultFixturesControllerApi.getApiClient().addDefaultHeader("Authorization", "Basic " + loginModel.getBasicAuth());
    }
}
