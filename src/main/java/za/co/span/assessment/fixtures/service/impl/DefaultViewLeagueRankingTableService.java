package za.co.span.assessment.fixtures.service.impl;

import za.co.span.assessment.fixtures.pojo.LoginModel;
import za.co.span.assessment.fixtures.pojo.Team;

import java.util.List;

public interface DefaultViewLeagueRankingTableService {
    List<Team> viewRankingTable(LoginModel loginModel);
}
