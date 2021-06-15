package za.co.span.assessment.security;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Component;

@Component
public class Base64CredentialEncoder {

    public String encodeUsernamePassword(String name, String password) {
        return new String(Base64.encodeBase64((name + ":" + password).getBytes()));
    }
}
