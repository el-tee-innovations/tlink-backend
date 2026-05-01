package za.co.tlinkportal.assessment.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import za.co.tlinkportal.assessment.api.dto.request.CreateAssessmentRequest;
import za.co.tlinkportal.assessment.api.dto.request.SubmitAnswerRequest;
import za.co.tlinkportal.assessment.domain.Assessment;
import za.co.tlinkportal.assessment.domain.CandidateAnswer;
import za.co.tlinkportal.assessment.domain.CandidateAssessment;
import za.co.tlinkportal.assessment.domain.enums.AssessmentStatus;
import za.co.tlinkportal.assessment.infrastructure.AssessmentRepository;
import za.co.tlinkportal.assessment.infrastructure.CandidateAnswerRepository;
import za.co.tlinkportal.assessment.infrastructure.CandidateAssessmentRepository;

import java.time.LocalDateTime;

@Service
public class AssessmentService {

    private final AssessmentRepository assessmentRepository;
    private final CandidateAssessmentRepository candidateAssessmentRepository;
    private final CandidateAnswerRepository candidateAnswerRepository;

    @Autowired
    public AssessmentService(AssessmentRepository assessmentRepository, CandidateAssessmentRepository candidateAssessmentRepository, CandidateAnswerRepository candidateAnswerRepository) {
        this.assessmentRepository = assessmentRepository;
        this.candidateAssessmentRepository = candidateAssessmentRepository;
        this.candidateAnswerRepository = candidateAnswerRepository;
    }

    public Assessment createAssessment(CreateAssessmentRequest request) {

        Assessment assessment = new Assessment();
        assessment.setJobId(request.getJobId());
        assessment.setCompanyId(request.getCompanyId());
        assessment.setTitle(request.getTitle());
        assessment.setType(request.getType());
        assessment.setActive(true);
        assessment.setCreatedAt(LocalDateTime.now());

        return assessmentRepository.save(assessment);
    }

    public CandidateAssessment start(Long assessmentId, Long userId, Long jobApplicationId) {

        CandidateAssessment attempt = new CandidateAssessment();
        attempt.setAssessmentId(assessmentId);
        attempt.setUserId(userId);
        attempt.setJobApplicationId(jobApplicationId);
        attempt.setStatus(AssessmentStatus.IN_PROGRESS);
        attempt.setStartedAt(LocalDateTime.now());

        return candidateAssessmentRepository.save(attempt);
    }

    public void submitAnswer(Long attemptId, SubmitAnswerRequest request) {

        CandidateAnswer answer = new CandidateAnswer();
        answer.setCandidateAssessmentId(attemptId);
        answer.setQuestionId(request.getQuestionId());
        answer.setSelectedOptionIds(request.getSelectedOptionIds());

        candidateAnswerRepository.save(answer);
    }

    public void uploadSubmission(Long attemptId, MultipartFile file) {
        // TODO: Implement file upload logic
        throw new UnsupportedOperationException("Upload submission not implemented yet");
    }
}
