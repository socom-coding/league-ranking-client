package za.co.span.assessment.security;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Component;
import za.co.span.assessment.fixtures.model.LoginModel;

@Component
public class Base64CredentialEncoder {

    public void encodeUsernamePassword(LoginModel loginModel) {
        byte[] auth = Base64.encodeBase64((loginModel.getUsername() + ":" + loginModel.getPassword()).getBytes());
        loginModel.setBasicAuth(new String(auth));
    }
}
