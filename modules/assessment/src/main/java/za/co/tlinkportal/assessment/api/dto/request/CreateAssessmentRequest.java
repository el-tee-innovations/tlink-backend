package za.co.tlinkportal.assessment.api.dto.request;

import lombok.Getter;
import lombok.Setter;
import za.co.tlinkportal.assessment.domain.enums.AssessmentType;

@Getter
@Setter
public class CreateAssessmentRequest {

    private Long jobId;
    private Long companyId;

    private String title;
    private String description;

    private AssessmentType type;
}