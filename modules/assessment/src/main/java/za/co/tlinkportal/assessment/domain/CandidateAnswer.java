package za.co.tlinkportal.assessment.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class CandidateAnswer {

    @Id
    @GeneratedValue
    private Long id;

    private Long candidateAssessmentId;
    private Long questionId;

    private List<Long> selectedOptionIds; // store selected options
}
