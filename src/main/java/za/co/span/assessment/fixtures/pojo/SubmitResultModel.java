package za.co.span.assessment.fixtures.pojo;

import org.springframework.stereotype.Component;

@Component
public class SubmitResultModel {

    private ResultModel resultModel;

    public ResultModel getResultModel() {
        return resultModel;
    }

    public void setResultModel(ResultModel resultModel) {
        this.resultModel = resultModel;
    }
}
