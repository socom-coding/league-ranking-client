package za.co.span.assessment.fixtures.service;

import za.co.span.assessment.fixtures.model.SubmitResultModel;

public interface DefaultLeagueService {

    void submitResult(SubmitResultModel submitResultModel);

    void viewRankingTable(SubmitResultModel submitResultModel);
}
