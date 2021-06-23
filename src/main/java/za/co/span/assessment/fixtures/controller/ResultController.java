package za.co.span.assessment.fixtures.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import za.co.span.assessment.StartLeagueRankingClientApplication;

import java.util.Scanner;

@Component
public class ResultController {
    private static Logger LOG = LoggerFactory.getLogger(StartLeagueRankingClientApplication.class);

    public String setResult() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Result:");
        if (scanner.hasNext()) {
            return scanner.nextLine();
        }
        return null;
    }
}
