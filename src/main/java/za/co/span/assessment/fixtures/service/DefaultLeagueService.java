package za.co.span.assessment.fixtures.service;

import za.co.span.assessment.fixtures.pojo.LoginModel;
import za.co.span.assessment.fixtures.pojo.SubmitResultModel;
import za.co.span.assessment.fixtures.pojo.Team;

import java.util.List;

public interface DefaultLeagueService {

    void submitResult(LoginModel loginModel, SubmitResultModel submitResultModel);

    List<Team> viewRankingTable(LoginModel loginModel);
}
