package za.co.tlinkportal.skill.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.tlinkportal.skill.api.dto.request.CreateSkillRequest;
import za.co.tlinkportal.skill.api.dto.request.SkillBulkRequest;
import za.co.tlinkportal.skill.api.dto.response.SkillBulkResponse;
import za.co.tlinkportal.skill.api.dto.response.SkillResponse;
import za.co.tlinkportal.skill.application.SkillService;

@RestController
@RequestMapping("/api/skills")
@RequiredArgsConstructor
public class SkillController {

    private final SkillService skillService;

    @PostMapping
    public ResponseEntity<SkillResponse> create(@RequestBody CreateSkillRequest request) {
        return ResponseEntity.ok(skillService.create(request));
    }

    @PostMapping("/bulk-names")
    public ResponseEntity<SkillBulkResponse> getNames(@RequestBody SkillBulkRequest request) {
        return ResponseEntity.ok(skillService.getSkillNames(request.getIds()));
    }
}
