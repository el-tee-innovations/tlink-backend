package za.co.tlinkportal.recruitment.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SavedCandidate {

    @Id
    @GeneratedValue
    private Long id;

    private Long recruiterId;
    private Long candidateId;

    private String note; // optional

    private LocalDateTime savedAt;
}
