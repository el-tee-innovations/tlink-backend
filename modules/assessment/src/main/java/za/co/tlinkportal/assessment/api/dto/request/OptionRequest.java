package za.co.tlinkportal.assessment.api.dto.request;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class OptionRequest {

    @Id
    @GeneratedValue
    private Long id;
    private Long questionId;
    private String text;
    private boolean correct;
}
