package za.co.tlinkportal.cv.infrastructure.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;

@FeignClient(name = "skill-service")
public interface SkillClient {

    @PostMapping("/api/skills/bulk-names")
    Map<Long, String> getSkillNames(List<Long> request);
}
