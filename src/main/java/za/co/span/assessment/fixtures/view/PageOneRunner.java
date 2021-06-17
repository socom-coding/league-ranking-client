package za.co.span.assessment.fixtures.view;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import za.co.span.assessment.StartLeagueRankingClientApplication;
import za.co.span.assessment.fixtures.controller.OptionController;
import za.co.span.assessment.fixtures.pojo.LoginModel;

@Component
@Order(value = 1)
public class PageOneRunner implements CommandLineRunner {

    private static Logger LOG = LoggerFactory.getLogger(StartLeagueRankingClientApplication.class);

    private OptionController optionController;
    private LoginModel loginModel;

    boolean endProgramme = false;

    @Autowired
    public PageOneRunner(OptionController optionController, LoginModel loginModel) {
        this.optionController = optionController;
        this.loginModel = loginModel;
    }

    @Override
    public void run(String... args) throws Exception {
        while (!endProgramme) {
            OptionsView.getOptions();
            endProgramme = optionController.processOption(loginModel);
        }
    }
}
