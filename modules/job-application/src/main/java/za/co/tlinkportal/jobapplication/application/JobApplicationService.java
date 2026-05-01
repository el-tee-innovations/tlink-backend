package za.co.tlinkportal.jobapplication.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import za.co.tlinkportal.common.dto.job.response.JobDto;
import za.co.tlinkportal.common.enums.JobApplicationStatus;
import za.co.tlinkportal.jobapplication.api.dto.request.ApplyJobRequest;
import za.co.tlinkportal.jobapplication.api.dto.request.UpdateApplicationStatusRequest;
import za.co.tlinkportal.jobapplication.api.dto.response.JobApplicationResponse;
import za.co.tlinkportal.jobapplication.domain.JobApplication;
import za.co.tlinkportal.jobapplication.infrastructure.JobApplicationRepository;
import za.co.tlinkportal.jobapplication.infrastructure.client.JobClient;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JobApplicationService {

    private final JobApplicationRepository repository;
    private final JobApplicationMapper mapper;
    private final JobClient jobClient;

    public JobApplicationResponse apply(ApplyJobRequest request) {

        // prevent duplicate application
        repository.findByJobIdAndUserId(request.getJobId(), request.getUserId())
                .ifPresent(a -> {
                    throw new RuntimeException("Already applied");
                });

        // fetch job → get companyId
        JobDto job = jobClient.getJob(request.getJobId());

        JobApplication app = mapper.toEntity(request, job.getCompanyId());

        return mapper.toResponse(repository.save(app));
    }

    public List<JobApplicationResponse> getUserApplications(Long userId) {
        return repository.findByUserId(userId)
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    public List<JobApplicationResponse> getJobApplications(Long jobId) {
        return repository.findByJobId(jobId)
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    public JobApplicationResponse updateStatus(Long id, UpdateApplicationStatusRequest request) {

        JobApplication app = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Application not found"));

        app.setStatus(request.getStatus());
        app.setRecruiterNotes(request.getRecruiterNotes());
        app.setLastUpdatedAt(LocalDateTime.now());

        return mapper.toResponse(repository.save(app));
    }

    public void withdraw(Long id) {
        JobApplication app = repository.findById(id).orElseThrow();

        app.setStatus(JobApplicationStatus.WITHDRAWN);
        repository.save(app);
    }
}
