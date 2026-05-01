package za.co.tlinkportal.recruitment.api.dto.response;

import lombok.Builder;
import lombok.Data;
import za.co.tlinkportal.common.enums.JobRecruitmentStatus;

@Data
@Builder
public class RecruitmentResponse {

    private Long id;
    private Long jobId;
    private String jobTitle;

    private Long candidateId;
    private String candidateName;

    private JobRecruitmentStatus status;
}
