package za.co.span.assessment.fixtures.model;

public class LoginModel {
    private final String basicAuth;

    public LoginModel(String basicAuth) {
        this.basicAuth = basicAuth;
    }

    public String getBasicAuth() {
        return basicAuth;
    }

}
