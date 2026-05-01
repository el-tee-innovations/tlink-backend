package za.co.tlinkportal.recruitment.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import za.co.tlinkportal.recruitment.api.dto.request.SaveCandidateRequest;
import za.co.tlinkportal.recruitment.application.SavedCandidateService;

import java.util.List;

@RestController
@RequestMapping("/api/recruitment/saved")
@RequiredArgsConstructor
public class SavedCandidateController {

    private final SavedCandidateService service;

    @PostMapping
    public void save(@RequestHeader("userId") Long recruiterId,
                     @RequestBody SaveCandidateRequest request) {
        service.save(recruiterId, request);
    }

    @GetMapping
    public List<Long> getSaved(@RequestHeader("userId") Long recruiterId) {
        return service.getSavedCandidates(recruiterId);
    }
}
