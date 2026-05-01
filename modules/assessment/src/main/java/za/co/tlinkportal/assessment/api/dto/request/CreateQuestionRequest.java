package za.co.tlinkportal.assessment.api.dto.request;

import lombok.Getter;
import lombok.Setter;
import za.co.tlinkportal.assessment.domain.enums.QuestionType;

import java.util.List;

@Getter
@Setter
public class CreateQuestionRequest {

    private String questionText;
    private QuestionType type;
    private Integer marks;

    private List<OptionRequest> options;
}
