package za.co.tlinkportal.assessment.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class AssessmentResource {

    @Id
    @GeneratedValue
    private Long id;

    private Long assessmentId;

    private String filePath;
    private String fileName;

    private LocalDateTime uploadedAt;
}
