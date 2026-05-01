package za.co.tlinkportal.company.domain;

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
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecruiterMembership {

    @Id
    @GeneratedValue
    private Long id;

    private Long userId;     // from User module

    private Long companyId;  // this module owns company

    private boolean active;

    private LocalDateTime joinedAt;
}
