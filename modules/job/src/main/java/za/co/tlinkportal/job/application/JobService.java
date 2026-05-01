package za.co.tlinkportal.job.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import za.co.tlinkportal.common.enums.JobListingStatus;
import za.co.tlinkportal.job.api.component.JobMapper;
import za.co.tlinkportal.job.api.dto.request.CreateJobRequest;
import za.co.tlinkportal.job.api.dto.response.JobResponse;
import za.co.tlinkportal.job.domain.Job;
import za.co.tlinkportal.job.infrastructure.JobRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobService {

    private final JobRepository repository;
    private final JobMapper mapper;

    public JobResponse createJob(CreateJobRequest request) {
        Job job = mapper.toEntity(request);
        return mapper.toResponse(repository.save(job));
    }

    public JobResponse getJob(Long id) {
        return repository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Job not found"));
    }

    public List<JobResponse> getCompanyJobs(Long companyId) {
        return repository.findByCompanyId(companyId)
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    public void openJob(Long id) {
        Job job = repository.findById(id).orElseThrow();
        job.setStatus(JobListingStatus.OPEN);
        repository.save(job);
    }

    public void closeJob(Long id) {
        Job job = repository.findById(id).orElseThrow();
        job.setStatus(JobListingStatus.CLOSED);
        repository.save(job);
    }
}
