package za.co.tlinkportal.recruitment.infrastructure.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@FeignClient(name = "recruitment-skill-service", url = "http://localhost:8080")
public interface SkillClient {
    @PostMapping("/api/skills/bulk-names")
    Map<Long, String> getSkillNames(@RequestBody List<Long> request);
}
