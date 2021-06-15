package za.co.span.assessment.fixtures.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.co.span.assessment.StartLeagueRankingClientApplication;
import za.co.span.assessment.fixtures.model.ResultModel;
import za.co.span.assessment.fixtures.model.SubmitResultModel;
import za.co.span.assessment.fixtures.service.DefaultLeagueService;
import za.co.span.assessment.fixtures.view.LoginView;

@Component
public class CaptureResultController {

    private static Logger LOG = LoggerFactory.getLogger(StartLeagueRankingClientApplication.class);

    private ResultController resultController;
    private ResultModel resultModel;
    private DefaultLeagueService defaultLeagueService;
    private LoginView loginView;

    @Autowired
    public CaptureResultController(DefaultLeagueService defaultLeagueService, LoginView loginView) {
        this.defaultLeagueService = defaultLeagueService;
        this.loginView = loginView;
    }

    public void captureResults(SubmitResultModel submitResultModel) {
        if (submitResultModel.getLoginModel().getBasicAuth().isEmpty()) {
            getLoginDetails(submitResultModel);
        }
        getResultDetails(submitResultModel);
        captureResult(submitResultModel);
    }

    private void captureResult(SubmitResultModel submitResultModel) {
        defaultLeagueService.submitResult(submitResultModel);
    }

    private void getResultDetails(SubmitResultModel submitResultModel) {
        resultController = new ResultController();
        resultModel = resultController.setResult();
        submitResultModel.setResultModel(resultModel);
    }

    private void getLoginDetails(SubmitResultModel submitResultModel) {
        submitResultModel.setLoginModel(loginView.setLogin());
    }
}
