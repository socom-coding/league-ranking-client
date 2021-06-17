package za.co.span.assessment.fixtures.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import za.co.span.assessment.StartLeagueRankingClientApplication;
import za.co.span.assessment.fixtures.pojo.ResultModel;

import java.util.Scanner;

public class ResultController {
    private static Logger LOG = LoggerFactory.getLogger(StartLeagueRankingClientApplication.class);

    public ResultModel setResult() {
        ResultModel resultModel = new ResultModel();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Result:");
        if (scanner.hasNext()) {
            resultModel.setResult(scanner.nextLine());
        }
        return resultModel;
    }
}
