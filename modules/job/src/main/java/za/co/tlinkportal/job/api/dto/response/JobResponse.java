package za.co.tlinkportal.job.api.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import za.co.tlinkportal.common.enums.JobListingStatus;
import za.co.tlinkportal.common.enums.JobType;

import java.util.List;

@Getter
@Setter
@Builder
public class JobResponse {

    private Long id;
    private Long companyId;

    private String title;
    private String description;
    private String location;

    private JobType jobType;
    private JobListingStatus status;

    private Integer minExperience;
    private Integer maxExperience;

    private List<JobSkillResponse> skills;
}
