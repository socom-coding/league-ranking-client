package za.co.span.assessment.fixtures.service;

import za.co.span.assessment.fixtures.pojo.LoginModel;
import za.co.span.assessment.fixtures.pojo.ResultModel;

public interface DefaultLeagueResultsService {
    void submitResult(LoginModel loginModel, ResultModel resultModel);
}
