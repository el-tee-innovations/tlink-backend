package za.co.tlinkportal.job.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobSkill {

    @Id
    @GeneratedValue
    private Long id;

    private Long skillId;

    private int requiredLevel;
    private boolean mandatory;

    @ManyToOne
    @JoinColumn
    private Job job;
}
