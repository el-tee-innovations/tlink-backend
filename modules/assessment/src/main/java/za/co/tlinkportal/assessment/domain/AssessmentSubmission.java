package za.co.tlinkportal.assessment.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import za.co.tlinkportal.assessment.domain.enums.SubmissionType;

import java.time.LocalDateTime;

@Entity
public class AssessmentSubmission {

    @Id
    @GeneratedValue
    private Long id;

    private Long candidateAssessmentId;

    private String filePath;
    private String fileName;

    private SubmissionType type; // PDF or ZIP

    private LocalDateTime uploadedAt;
}
