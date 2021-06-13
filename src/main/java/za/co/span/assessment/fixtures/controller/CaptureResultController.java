package za.co.span.assessment.fixtures.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.co.span.assessment.StartLeagueRankingClientApplication;
import za.co.span.assessment.fixtures.model.SubmitResultModel;
import za.co.span.assessment.fixtures.service.DefaultLeagueService;

@Component
public class CaptureResultController {

    private static Logger LOG = LoggerFactory.getLogger(StartLeagueRankingClientApplication.class);

    private DefaultLeagueService defaultLeagueService;

    @Autowired
    public CaptureResultController(DefaultLeagueService defaultLeagueService) {
        this.defaultLeagueService = defaultLeagueService;
    }

    public void captureResult(SubmitResultModel submitResultModel) {
        defaultLeagueService.submitResult(submitResultModel);
    }
}
