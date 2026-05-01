package za.co.tlinkportal.cv.api.controller;

import org.springframework.web.bind.annotation.*;
import za.co.tlinkportal.common.dto.cv.request.CvUpdateSkillsRequest;
import za.co.tlinkportal.common.dto.cv.response.CvSkillDto;
import za.co.tlinkportal.cv.api.dto.request.CvCreateRequest;
import za.co.tlinkportal.common.dto.cv.response.CvResponse;
import za.co.tlinkportal.cv.application.CvService;
import za.co.tlinkportal.cv.application.CvSkillService;

import java.util.List;

@RestController
@RequestMapping("/api/cv")
public class CvController {

    private final CvService cvService;
    private final CvSkillService cvSkillService;

    public CvController(CvService cvService, CvSkillService cvSkillService) {
        this.cvService = cvService;
        this.cvSkillService = cvSkillService;
    }

    @GetMapping("/{userId}")
    public CvResponse getCv(@PathVariable Long userId) {
        return cvService.getCvByUserId(userId);
    }

    @PostMapping
    public Long createCv(@RequestBody CvCreateRequest request) {
        return cvService.createCv(request);
    }

    @PutMapping("/{userId}/skills")
    public void updateSkills(@PathVariable Long userId, @RequestBody CvUpdateSkillsRequest request) {
        cvService.updateSkills(userId, request);
    }

    @GetMapping("/{userId}/skills")
    public List<String> getSkillIds(@PathVariable Long userId) {
        return cvSkillService.getSkillsByUserId(userId);
    }

    @PostMapping("/search")
    public List<CvSkillDto> searchBySkills(@RequestBody List<Long> skillIds) {
        return cvSkillService.findBySkillIdIn(skillIds);
    }
}
