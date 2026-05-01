package za.co.tlinkportal.job.api.component;

import org.springframework.stereotype.Component;
import za.co.tlinkportal.common.enums.JobListingStatus;
import za.co.tlinkportal.job.api.dto.request.CreateJobRequest;
import za.co.tlinkportal.job.api.dto.response.JobResponse;
import za.co.tlinkportal.job.api.dto.response.JobSkillResponse;
import za.co.tlinkportal.job.domain.Job;
import za.co.tlinkportal.job.domain.JobSkill;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class JobMapper {

    public Job toEntity(CreateJobRequest request) {

        Job job = new Job();
        job.setCompanyId(request.getCompanyId());
        job.setTitle(request.getTitle());
        job.setDescription(request.getDescription());
        job.setLocation(request.getLocation());
        job.setJobType(request.getJobType());
        job.setStatus(JobListingStatus.DRAFT);
        job.setCreatedAt(LocalDateTime.now());

        List<JobSkill> skills = request.getSkills().stream().map(s -> {
            JobSkill js = new JobSkill();
            js.setSkillId(s.getSkillId());
            js.setRequiredLevel(s.getRequiredLevel());
            js.setMandatory(s.isMandatory());
            js.setJob(job);
            return js;
        }).toList();

        job.setSkills(skills);

        return job;
    }

    public JobResponse toResponse(Job job) {
        return JobResponse.builder()
                .id(job.getId())
                .companyId(job.getCompanyId())
                .title(job.getTitle())
                .description(job.getDescription())
                .location(job.getLocation())
                .jobType(job.getJobType())
                .status(job.getStatus())
                .minExperience(job.getMinExperience())
                .maxExperience(job.getMaxExperience())
                .skills(
                        job.getSkills().stream().map(s ->
                                JobSkillResponse.builder()
                                        .skillId(s.getSkillId())
                                        .requiredLevel(s.getRequiredLevel())
                                        .mandatory(s.isMandatory())
                                        .build()
                        ).toList()
                )
                .build();
    }
}