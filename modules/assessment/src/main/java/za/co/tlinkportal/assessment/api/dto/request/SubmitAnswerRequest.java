package za.co.tlinkportal.assessment.api.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SubmitAnswerRequest {

    private Long questionId;
    private List<Long> selectedOptionIds;
}
