package za.co.tlinkportal.jobapplication.api.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplyJobRequest {

    private Long jobId;
    private Long userId;
    private String coverLetter;
}
