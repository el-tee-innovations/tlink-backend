package za.co.tlinkportal.jobapplication.application;

import org.springframework.stereotype.Component;
import za.co.tlinkportal.common.enums.JobApplicationStatus;
import za.co.tlinkportal.jobapplication.api.dto.request.ApplyJobRequest;
import za.co.tlinkportal.jobapplication.api.dto.response.JobApplicationResponse;
import za.co.tlinkportal.jobapplication.domain.JobApplication;

import java.time.LocalDateTime;

@Component
public class JobApplicationMapper {

    public JobApplication toEntity(ApplyJobRequest request, Long companyId) {

        JobApplication app = new JobApplication();
        app.setJobId(request.getJobId());
        app.setUserId(request.getUserId());
        app.setCompanyId(companyId);
        app.setCoverLetter(request.getCoverLetter());

        app.setStatus(JobApplicationStatus.APPLIED);
        app.setAppliedAt(LocalDateTime.now());
        app.setLastUpdatedAt(LocalDateTime.now());

        return app;
    }

    public JobApplicationResponse toResponse(JobApplication app) {
        return JobApplicationResponse.builder()
                .id(app.getId())
                .jobId(app.getJobId())
                .userId(app.getUserId())
                .companyId(app.getCompanyId())
                .status(app.getStatus())
                .appliedAt(app.getAppliedAt())
                .lastUpdatedAt(app.getLastUpdatedAt())
                .coverLetter(app.getCoverLetter())
                .recruiterNotes(app.getRecruiterNotes())
                .build();
    }
}
