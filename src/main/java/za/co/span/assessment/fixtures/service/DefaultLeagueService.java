package za.co.span.assessment.fixtures.service;

import za.co.span.assessment.fixtures.pojo.LoginModel;
import za.co.span.assessment.fixtures.pojo.ResultModel;
import za.co.span.assessment.fixtures.pojo.Team;

import java.util.List;

public interface DefaultLeagueService {

    void submitResult(LoginModel loginModel, ResultModel resultModel);

    List<Team> viewRankingTable(LoginModel loginModel);
}
