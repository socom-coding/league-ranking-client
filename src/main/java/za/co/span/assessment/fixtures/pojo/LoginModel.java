package za.co.span.assessment.fixtures.pojo;

import org.springframework.stereotype.Component;

@Component
public class LoginModel {
    private String basicAuth;

    public String getBasicAuth() {
        return basicAuth;
    }

    public void setBasicAuth(String basicAuth) {
        this.basicAuth = basicAuth;
    }

    public boolean isEmpty() {
        if (basicAuth == null) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

}
