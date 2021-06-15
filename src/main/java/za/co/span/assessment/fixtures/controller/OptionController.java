package za.co.span.assessment.fixtures.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.co.span.assessment.security.Base64CredentialEncoder;

import java.util.Scanner;

@Component
public class OptionController {

    private CaptureResultController captureResultController;
    private RankingTableController rankingTableController;
    private Base64CredentialEncoder base64CredentialEncoder;

    @Autowired
    public OptionController(CaptureResultController captureResultController, RankingTableController rankingTableController, Base64CredentialEncoder base64CredentialEncoder) {
        this.captureResultController = captureResultController;
        this.rankingTableController = rankingTableController;
        this.base64CredentialEncoder = base64CredentialEncoder;
    }

    public Boolean processOption() {
        String option = null;

        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNext()) {
            option = scanner.nextLine();
        }

        switch (option) {
            case "1":
                captureResultController.captureResults();
                break;
            case "2":
                rankingTableController.viewRanking();
                break;
            case "3":
                return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
