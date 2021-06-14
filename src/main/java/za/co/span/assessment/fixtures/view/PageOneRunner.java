package za.co.span.assessment.fixtures.view;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import za.co.span.assessment.StartLeagueRankingClientApplication;
import za.co.span.assessment.fixtures.controller.CaptureResultController;
import za.co.span.assessment.fixtures.controller.LoginController;
import za.co.span.assessment.fixtures.controller.RankingTableController;
import za.co.span.assessment.fixtures.controller.ResultController;
import za.co.span.assessment.fixtures.model.LoginModel;
import za.co.span.assessment.fixtures.model.ResultModel;
import za.co.span.assessment.fixtures.model.SubmitResultModel;
import za.co.span.assessment.security.Base64CredentialEncoder;

import java.util.Scanner;

@Component
@Order(value = 1)
public class PageOneRunner implements CommandLineRunner {

    private static Logger LOG = LoggerFactory.getLogger(StartLeagueRankingClientApplication.class);

    private LoginModel loginModel;
    private ResultModel resultModel;
    private SubmitResultModel submitResultModel;
    private LoginController loginController;
    private ResultController resultController;
    private CaptureResultController captureResultController;
    private RankingTableController rankingTableController;
    private Base64CredentialEncoder base64CredentialEncoder;

    @Autowired
    public PageOneRunner(CaptureResultController captureResultController, RankingTableController rankingTableController, Base64CredentialEncoder base64CredentialEncoder) {
        this.captureResultController = captureResultController;
        this.rankingTableController = rankingTableController;
        this.base64CredentialEncoder = base64CredentialEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose Option By Entering The Corresponding Number:");
        System.out.println("1. Capture Results");
        System.out.println("2. View Ranking Table");

        String option = null;

        if (scanner.hasNext()) {
            option = scanner.nextLine();
        }

        switch (option) {
            case "1":
                submitResultModel = new SubmitResultModel();
                getLoginDetails(submitResultModel);
                getResultDetails(submitResultModel);
                submitResult(submitResultModel);
                break;
            case "2":
                submitResultModel = new SubmitResultModel();
                getLoginDetails(submitResultModel);
                viewRankingTable();
                break;
        }
    }

    private void viewRankingTable() {
        rankingTableController.viewRankingTable(submitResultModel);
    }

    private void submitResult(SubmitResultModel submitResultModel) {
        captureResultController.captureResult(submitResultModel);
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
