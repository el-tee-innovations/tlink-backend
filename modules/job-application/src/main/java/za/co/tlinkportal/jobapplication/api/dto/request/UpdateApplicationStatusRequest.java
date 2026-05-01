package za.co.tlinkportal.jobapplication.api.dto.request;

import lombok.Getter;
import lombok.Setter;
import za.co.tlinkportal.common.enums.JobApplicationStatus;

@Getter
@Setter
public class UpdateApplicationStatusRequest {

    private JobApplicationStatus status;
    private String recruiterNotes;
}
