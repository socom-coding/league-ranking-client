package za.co.span.assessment.fixtures.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.co.span.assessment.StartLeagueRankingClientApplication;
import za.co.span.assessment.fixtures.pojo.LoginModel;
import za.co.span.assessment.fixtures.pojo.ResultModel;
import za.co.span.assessment.fixtures.service.DefaultLeagueResultsService;
import za.co.span.assessment.fixtures.view.LoginView;

@Component
public class CaptureResultController {

    private static Logger LOG = LoggerFactory.getLogger(StartLeagueRankingClientApplication.class);

    private ResultController resultController;
    private DefaultLeagueResultsService defaultLeagueService;
    private LoginView loginView;
    private ResultModel resultModel;

    @Autowired
    public CaptureResultController(DefaultLeagueResultsService defaultLeagueService, LoginView loginView, ResultModel resultModel) {
        this.defaultLeagueService = defaultLeagueService;
        this.loginView = loginView;
        this.resultModel = resultModel;
    }

    public void captureResults(LoginModel loginModel) {

        if (loginModel.isEmpty()) {
            loginModel.setBasicAuth(getLoginDetails());
        }
        resultModel.setResult(getResultDetails());
        captureResult(loginModel, resultModel);
    }

    private void captureResult(LoginModel loginModel, ResultModel resultModel) {
        defaultLeagueService.submitResult(loginModel, resultModel);
    }

    private String getResultDetails() {
        resultController = new ResultController();
        return resultController.setResult();
    }

    private String getLoginDetails() {
        return loginView.setLogin();

    }
}
