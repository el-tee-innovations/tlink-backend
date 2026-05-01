package za.co.tlinkportal.job.api.dto.request;

import lombok.Getter;
import lombok.Setter;
import za.co.tlinkportal.common.enums.JobType;

import java.util.List;

@Getter
@Setter
public class CreateJobRequest {

    private Long companyId;

    private String title;
    private String description;
    private String location;

    private JobType jobType;

    private Integer minExperience;
    private Integer maxExperience;

    private List<JobSkillRequest> skills;
}
