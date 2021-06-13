package za.co.span.assessment.fixtures.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import za.co.span.assessment.StartLeagueRankingClientApplication;
import za.co.span.assessment.fixtures.model.LoginModel;

import java.util.Scanner;

public class LoginController {
    private static Logger LOG = LoggerFactory.getLogger(StartLeagueRankingClientApplication.class);

    public LoginModel setLogin() {
        LoginModel loginModel = new LoginModel();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Username:");
        if (scanner.hasNext()) {
            loginModel.setUsername(scanner.nextLine());
        }

        System.out.println("Enter Password:");
        if (scanner.hasNext()) {
            loginModel.setPassword(scanner.nextLine());
        }
        return loginModel;
    }
}
