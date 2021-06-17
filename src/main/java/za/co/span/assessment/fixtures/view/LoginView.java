package za.co.span.assessment.fixtures.view;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import za.co.span.assessment.StartLeagueRankingClientApplication;
import za.co.span.assessment.security.Base64CredentialEncoder;

import java.util.Scanner;

@Component
public class LoginView {
    private static Logger LOG = LoggerFactory.getLogger(StartLeagueRankingClientApplication.class);

    private Base64CredentialEncoder base64CredentialEncoder;

    public LoginView(Base64CredentialEncoder base64CredentialEncoder) {
        this.base64CredentialEncoder = base64CredentialEncoder;
    }

    public String setLogin() {
        Scanner scanner = new Scanner(System.in);

        String name = "";
        String password = "";

        System.out.println("Enter Username:");
        if (scanner.hasNext()) {
            name = scanner.nextLine();
        }

        System.out.println("Enter Password:");
        if (scanner.hasNext()) {
            password = scanner.nextLine();
        }
        return base64CredentialEncoder.encodeUsernamePassword(name, password);
    }
}
