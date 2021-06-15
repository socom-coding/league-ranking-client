package za.co.span.assessment.fixtures.controller;

import leaguerankingservice.consume.model.LeagueRanking;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.co.span.assessment.StartLeagueRankingClientApplication;
import za.co.span.assessment.fixtures.model.LoginModel;
import za.co.span.assessment.fixtures.model.SubmitResultModel;
import za.co.span.assessment.fixtures.service.DefaultLeagueService;
import za.co.span.assessment.security.Base64CredentialEncoder;

import java.util.List;

@Component
public class RankingTableController {

    private static Logger LOG = LoggerFactory.getLogger(StartLeagueRankingClientApplication.class);

    private SubmitResultModel submitResultModel;
    private LoginController loginController;
    private DefaultLeagueService defaultLeagueService;
    private Base64CredentialEncoder base64CredentialEncoder;
    private LoginModel loginModel;

    @Autowired
    public RankingTableController(DefaultLeagueService defaultLeagueService, Base64CredentialEncoder base64CredentialEncoder) {
        this.defaultLeagueService = defaultLeagueService;
        this.base64CredentialEncoder = base64CredentialEncoder;
    }

    public void viewRanking() {
        submitResultModel = new SubmitResultModel();
        getLoginDetails(submitResultModel);
        displayRankingTable();
    }

    private void displayRankingTable() {
        List<LeagueRanking> leagueRankings = getRankingTable(submitResultModel);
        for (LeagueRanking leagueRanking : leagueRankings) {
            System.out.println(leagueRanking.getPosition() + ". " + leagueRanking.getName() + ", " + leagueRanking.getPoints() + " pts");
        }
    }

    private void getLoginDetails(SubmitResultModel submitResultModel) {
        loginController = new LoginController();
        loginModel = loginController.setLogin();
        base64CredentialEncoder.encodeUsernamePassword(loginModel);
        submitResultModel.setLoginModel(loginModel);
    }

    private List<LeagueRanking> getRankingTable(SubmitResultModel submitResultModel) {
        return defaultLeagueService.viewRankingTable(submitResultModel);
    }
}
