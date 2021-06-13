package za.co.span.assessment.fixtures.service.impl;

import leaguerankingservice.consume.api.DefaultFixturesControllerApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import za.co.span.assessment.fixtures.model.SubmitResultModel;
import za.co.span.assessment.fixtures.service.DefaultLeagueService;

import javax.annotation.PostConstruct;

@Service
public class DefaultLeagueServiceImpl implements DefaultLeagueService {
    private static final Logger log = LoggerFactory.getLogger(DefaultLeagueServiceImpl.class);

    private DefaultFixturesControllerApi defaultFixturesControllerApi;

    private String basePath = "http://localhost:9009/api";

    @PostConstruct
    private void setupApiClient() {
        defaultFixturesControllerApi = new DefaultFixturesControllerApi();
        defaultFixturesControllerApi.getApiClient().setBasePath(basePath);
    }

    @Override
    public void submitResult(SubmitResultModel submitResultModel) {
        defaultFixturesControllerApi.getApiClient().addDefaultHeader("Authorization", "Basic " + submitResultModel.getLoginModel().getBasicAuth());
        defaultFixturesControllerApi.captureResultUsingPOST(submitResultModel.getResultModel().getResult());
    }

    @Override
    public void viewRankingTable() {

    }
}
