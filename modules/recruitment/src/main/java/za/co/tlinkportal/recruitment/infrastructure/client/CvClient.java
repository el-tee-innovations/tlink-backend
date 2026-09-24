package za.co.tlinkportal.recruitment.infrastructure.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import za.co.tlinkportal.common.dto.cv.response.CvSkillDto;
import za.co.tlinkportal.common.dto.cv.response.CvResponse;

import java.util.List;

@FeignClient(name = "recruitment-cv-service", url = "http://localhost:8080")
public interface CvClient {

    @PostMapping("/api/cv/skills/search")
    List<CvSkillDto> findCandidatesBySkills(@RequestBody List<Long> skillIds);

    @RequestMapping("/api/cv/{userId}")
    CvResponse getByUserId(@RequestParam("userId") Long userId);
}
