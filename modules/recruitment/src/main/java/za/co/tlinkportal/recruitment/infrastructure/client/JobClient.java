package za.co.tlinkportal.recruitment.infrastructure.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import za.co.tlinkportal.common.dto.job.response.JobDto;

@FeignClient(name = "recruitment-job-service", url = "http://localhost:8080")
public interface JobClient {

    @GetMapping("/api/jobs/{id}")
    JobDto getJob(@PathVariable("id") Long id);
}