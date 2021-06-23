package za.co.span.assessment.fixtures.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.co.span.assessment.StartLeagueRankingClientApplication;
import za.co.span.assessment.fixtures.pojo.LoginModel;
import za.co.span.assessment.fixtures.pojo.Team;
import za.co.span.assessment.fixtures.service.impl.DefaultViewLeagueRankingTableService;
import za.co.span.assessment.fixtures.view.LoginView;

import java.util.List;

@Component
public class RankingTableController {

    private static Logger LOG = LoggerFactory.getLogger(StartLeagueRankingClientApplication.class);

    private DefaultViewLeagueRankingTableService defaultViewLeagueRankingTableService;
    private LoginView loginView;

    @Autowired
    public RankingTableController(DefaultViewLeagueRankingTableService defaultViewLeagueRankingTableService, LoginView loginView) {
        this.defaultViewLeagueRankingTableService = defaultViewLeagueRankingTableService;
        this.loginView = loginView;
    }

    public void viewRanking(LoginModel loginModel) {
        if (loginModel.isEmpty()) {
            loginModel.setBasicAuth(getLoginDetails());
        }
        displayRankingTable(loginModel);
    }

    private void displayRankingTable(LoginModel loginModel) {
        List<Team> teamList = getRankingTable(loginModel);
        System.out.println("##########################################################################################################################");
        teamList.forEach(team -> System.out.println(team.getPosition() + ". " + team.getName() + ", " + team.getPoints() + " pts"));
        System.out.println("##########################################################################################################################");
    }

    private String getLoginDetails() {
        return loginView.setLogin();
    }

    private List<Team> getRankingTable(LoginModel loginModel) {
        return defaultViewLeagueRankingTableService.viewRankingTable(loginModel);
    }
}
