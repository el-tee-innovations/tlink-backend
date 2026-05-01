package za.co.tlinkportal.recruitment.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import za.co.tlinkportal.recruitment.api.dto.request.RecruitCandidateRequest;
import za.co.tlinkportal.recruitment.api.dto.response.RecruitmentResponse;
import za.co.tlinkportal.recruitment.application.RecruitmentService;

import java.util.List;

@RestController
@RequestMapping("/api/recruitment")
@RequiredArgsConstructor
public class RecruitmentController {

    private final RecruitmentService service;

    @PostMapping("/invite")
    public void recruit(@RequestHeader("userId") Long recruiterId,
                        @RequestBody RecruitCandidateRequest request) {
        service.recruit(recruiterId, request);
    }

    @GetMapping("/candidate/{candidateId}")
    public List<RecruitmentResponse> getForCandidate(@PathVariable Long candidateId) {
        return service.getRecruitmentsForCandidate(candidateId);
    }

    @DeleteMapping("/invite")
    public void cancelInvite(@RequestParam Long recruiterId, Long candidateId) {
        service.cancelInvite(recruiterId, candidateId);
    }
}