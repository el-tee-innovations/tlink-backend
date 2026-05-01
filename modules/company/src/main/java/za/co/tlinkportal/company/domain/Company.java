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
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Company {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

    private String website;

    private String logoUrl;

    private String industry;

    private String location;

    @Builder.Default
    private boolean active = true;

    private LocalDateTime createdAt;
}
