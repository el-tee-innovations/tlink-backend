package za.co.tlinkportal.jobapplication.api.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import za.co.tlinkportal.common.enums.JobApplicationStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class JobApplicationResponse {

    private Long id;
    private Long jobId;
    private Long userId;
    private Long companyId;

    private JobApplicationStatus status;

    private LocalDateTime appliedAt;
    private LocalDateTime lastUpdatedAt;

    private String coverLetter;
    private String recruiterNotes;
}
