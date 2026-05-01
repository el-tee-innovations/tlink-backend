package za.co.tlinkportal.assessment.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import za.co.tlinkportal.assessment.domain.enums.AssessmentStatus;

import java.time.LocalDateTime;

@Entity
@Data
public class CandidateAssessment {

    @Id
    @GeneratedValue
    private Long id;

    private Long assessmentId;
    private Long userId;
    private Long jobApplicationId;

    private AssessmentStatus status;

    private Integer score;

    private LocalDateTime startedAt;
    private LocalDateTime submittedAt;
}