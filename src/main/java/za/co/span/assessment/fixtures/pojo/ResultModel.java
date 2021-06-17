package za.co.span.assessment.fixtures.pojo;

import org.springframework.stereotype.Component;

@Component
public class ResultModel {
    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
