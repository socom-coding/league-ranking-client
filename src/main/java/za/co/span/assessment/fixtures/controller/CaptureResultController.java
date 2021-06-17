package za.co.span.assessment.fixtures.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.co.span.assessment.StartLeagueRankingClientApplication;
import za.co.span.assessment.fixtures.pojo.LoginModel;
import za.co.span.assessment.fixtures.pojo.ResultModel;
import za.co.span.assessment.fixtures.pojo.SubmitResultModel;
import za.co.span.assessment.fixtures.service.DefaultLeagueService;
import za.co.span.assessment.fixtures.view.LoginView;

@Component
public class CaptureResultController {

    private static Logger LOG = LoggerFactory.getLogger(StartLeagueRankingClientApplication.class);

    private ResultController resultController;
    private DefaultLeagueService defaultLeagueService;
    private LoginView loginView;
    private SubmitResultModel submitResultModel;

    @Autowired
    public CaptureResultController(DefaultLeagueService defaultLeagueService, LoginView loginView, SubmitResultModel submitResultModel) {
        this.defaultLeagueService = defaultLeagueService;
        this.loginView = loginView;
        this.submitResultModel = submitResultModel;
    }

    public void captureResults(LoginModel loginModel) {

        if (loginModel.isEmpty()) {
            loginModel.setBasicAuth(getLoginDetails());
        }
        submitResultModel.setLoginModel(loginModel);
        submitResultModel.setResultModel(getResultDetails());
        captureResult(submitResultModel);
    }

    private void captureResult(SubmitResultModel submitResultModel) {
        defaultLeagueService.submitResult(submitResultModel);
    }

    private ResultModel getResultDetails() {
        resultController = new ResultController();
        return resultController.setResult();
    }

    private String getLoginDetails() {
        return loginView.setLogin();

    }
}
