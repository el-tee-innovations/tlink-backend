package za.co.tlinkportal.assessment.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Option {

    @Id
    @GeneratedValue
    private Long id;

    private Long questionId;

    private String text;

    private boolean correct; // used for auto grading
}
