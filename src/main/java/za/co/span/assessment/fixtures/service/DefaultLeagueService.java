package za.co.span.assessment.fixtures.service;

import leaguerankingservice.consume.model.LeagueRanking;
import za.co.span.assessment.fixtures.model.SubmitResultModel;

import java.util.List;

public interface DefaultLeagueService {

    void submitResult(SubmitResultModel submitResultModel);

    List<LeagueRanking> viewRankingTable(SubmitResultModel submitResultModel);
}
