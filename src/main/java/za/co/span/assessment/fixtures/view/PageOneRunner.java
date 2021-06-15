package za.co.span.assessment.fixtures.view;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import za.co.span.assessment.StartLeagueRankingClientApplication;
import za.co.span.assessment.fixtures.controller.OptionController;
import za.co.span.assessment.fixtures.model.SubmitResultModel;

@Component
@Order(value = 1)
public class PageOneRunner implements CommandLineRunner {

    private static Logger LOG = LoggerFactory.getLogger(StartLeagueRankingClientApplication.class);

    private OptionController optionController;
    private SubmitResultModel submitResultModel;

    boolean endProgramme = false;

    @Autowired
    public PageOneRunner(OptionController optionController, SubmitResultModel submitResultModel) {
        this.optionController = optionController;
        this.submitResultModel = submitResultModel;
    }

    @Override
    public void run(String... args) throws Exception {
        while (!endProgramme) {
            OptionsView.getOptions();
            endProgramme = optionController.processOption(submitResultModel);
        }
    }
}
