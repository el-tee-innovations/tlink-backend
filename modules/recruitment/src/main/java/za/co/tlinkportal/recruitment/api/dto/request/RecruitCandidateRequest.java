package za.co.tlinkportal.recruitment.api.dto.request;

import lombok.Data;

@Data
public class RecruitCandidateRequest {

    private Long jobId;
    private Long candidateId;
    private String message;
}
