package za.co.span.assessment.fixtures.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.co.span.assessment.StartLeagueRankingClientApplication;
import za.co.span.assessment.fixtures.model.LoginModel;
import za.co.span.assessment.fixtures.model.ResultModel;
import za.co.span.assessment.fixtures.model.SubmitResultModel;
import za.co.span.assessment.fixtures.service.DefaultLeagueService;
import za.co.span.assessment.security.Base64CredentialEncoder;

@Component
public class CaptureResultController {

    private static Logger LOG = LoggerFactory.getLogger(StartLeagueRankingClientApplication.class);

    private SubmitResultModel submitResultModel;
    private ResultController resultController;
    private ResultModel resultModel;
    private LoginController loginController;
    private LoginModel loginModel;
    private Base64CredentialEncoder base64CredentialEncoder;
    private DefaultLeagueService defaultLeagueService;

    @Autowired
    public CaptureResultController(Base64CredentialEncoder base64CredentialEncoder, DefaultLeagueService defaultLeagueService) {
        this.base64CredentialEncoder = base64CredentialEncoder;
        this.defaultLeagueService = defaultLeagueService;
    }

    public void captureResults() {
        submitResultModel = new SubmitResultModel();
        getLoginDetails(submitResultModel);
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
        loginController = new LoginController();
        loginModel = loginController.setLogin();
        base64CredentialEncoder.encodeUsernamePassword(loginModel);
        submitResultModel.setLoginModel(loginModel);
    }
}
