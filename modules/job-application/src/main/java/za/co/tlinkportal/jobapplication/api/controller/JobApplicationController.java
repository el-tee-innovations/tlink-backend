package za.co.tlinkportal.jobapplication.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import za.co.tlinkportal.jobapplication.api.dto.request.ApplyJobRequest;
import za.co.tlinkportal.jobapplication.api.dto.request.UpdateApplicationStatusRequest;
import za.co.tlinkportal.jobapplication.api.dto.response.JobApplicationResponse;
import za.co.tlinkportal.jobapplication.application.JobApplicationService;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
@RequiredArgsConstructor
public class JobApplicationController {

    private final JobApplicationService service;

    @PostMapping
    public JobApplicationResponse apply(@RequestBody ApplyJobRequest request) {
        return service.apply(request);
    }

    @GetMapping("/user/{userId}")
    public List<JobApplicationResponse> getUserApplications(@PathVariable Long userId) {
        return service.getUserApplications(userId);
    }

    @GetMapping("/job/{jobId}")
    public List<JobApplicationResponse> getJobApplications(@PathVariable Long jobId) {
        return service.getJobApplications(jobId);
    }

    @PutMapping("/{id}/status")
    public JobApplicationResponse updateStatus(
            @PathVariable Long id,
            @RequestBody UpdateApplicationStatusRequest request
    ) {
        return service.updateStatus(id, request);
    }

    @PutMapping("/{id}/withdraw")
    public void withdraw(@PathVariable Long id) {
        service.withdraw(id);
    }
}