package za.co.tlinkportal.assessment.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import za.co.tlinkportal.assessment.domain.enums.AssessmentType;

import java.time.LocalDateTime;

@Entity
@Data
public class Assessment {

    @Id
    @GeneratedValue
    private Long id;

    private Long jobId;
    private Long companyId;

    private String title;
    private String description;

    private AssessmentType type; // MCQ or FILE

    private Integer timeLimitMinutes; // optional

    private boolean active;

    private LocalDateTime createdAt;
}
