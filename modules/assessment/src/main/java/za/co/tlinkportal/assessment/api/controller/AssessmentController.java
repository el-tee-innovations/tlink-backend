package za.co.tlinkportal.assessment.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import za.co.tlinkportal.assessment.api.dto.request.CreateAssessmentRequest;
import za.co.tlinkportal.assessment.api.dto.request.SubmitAnswerRequest;
import za.co.tlinkportal.assessment.application.AssessmentService;
import za.co.tlinkportal.assessment.domain.Assessment;
import za.co.tlinkportal.assessment.domain.CandidateAssessment;

@RestController
@RequestMapping("/api/assessments")
@RequiredArgsConstructor
public class AssessmentController {

    private final AssessmentService service;

    @PostMapping
    public Assessment create(@RequestBody CreateAssessmentRequest request) {
        return service.createAssessment(request);
    }

    @PostMapping("/{id}/start")
    public CandidateAssessment start(
            @PathVariable Long id,
            @RequestParam Long userId,
            @RequestParam Long jobApplicationId
    ) {
        return service.start(id, userId, jobApplicationId);
    }

    @PostMapping("/attempt/{attemptId}/answer")
    public void submitAnswer(
            @PathVariable Long attemptId,
            @RequestBody SubmitAnswerRequest request
    ) {
        service.submitAnswer(attemptId, request);
    }

    @PostMapping("/attempt/{attemptId}/upload")
    public void upload(
            @PathVariable Long attemptId,
            @RequestParam MultipartFile file
    ) {
        service.uploadSubmission(attemptId, file);
    }
}
