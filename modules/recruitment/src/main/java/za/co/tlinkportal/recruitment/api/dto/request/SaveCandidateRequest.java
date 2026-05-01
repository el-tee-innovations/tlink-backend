package za.co.tlinkportal.recruitment.api.dto.request;

import lombok.Data;

@Data
public class SaveCandidateRequest {

    private Long candidateId;
    private String note;
}
