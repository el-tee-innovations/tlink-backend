package za.co.tlinkportal.job.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import za.co.tlinkportal.job.api.dto.request.CreateJobRequest;
import za.co.tlinkportal.job.api.dto.response.JobResponse;
import za.co.tlinkportal.job.application.JobService;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
@RequiredArgsConstructor
public class JobController {

    private final JobService service;

    @PostMapping
    public JobResponse create(@RequestBody CreateJobRequest request) {
        return service.createJob(request);
    }

    @GetMapping("/{id}")
    public JobResponse get(@PathVariable Long id) {
        return service.getJob(id);
    }

    @GetMapping("/company/{companyId}")
    public List<JobResponse> getCompanyJobs(@PathVariable Long companyId) {
        return service.getCompanyJobs(companyId);
    }

    @PostMapping("/{id}/open")
    public void open(@PathVariable Long id) {
        service.openJob(id);
    }

    @PostMapping("/{id}/close")
    public void close(@PathVariable Long id) {
        service.closeJob(id);
    }
}