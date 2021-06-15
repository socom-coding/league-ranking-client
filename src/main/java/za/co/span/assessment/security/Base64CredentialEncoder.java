package za.co.span.assessment.security;

import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import za.co.span.assessment.StartLeagueRankingClientApplication;

@Component
public class Base64CredentialEncoder {

    private static Logger LOG = LoggerFactory.getLogger(StartLeagueRankingClientApplication.class);

    public String encodeUsernamePassword(String name, String password) {
        return new String(Base64.encodeBase64((name + ":" + password).getBytes()));
    }
}
