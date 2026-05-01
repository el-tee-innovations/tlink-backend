package za.co.tlinkportal.assessment.domain;

import jakarta.persistence.*;
import za.co.tlinkportal.assessment.domain.enums.QuestionType;

@Entity
public class Question {

    @Id
    @GeneratedValue
    private Long id;

    private Long assessmentId;

    private String questionText;

    @Enumerated(EnumType.STRING)
    private QuestionType type;

    private Integer marks;
}
