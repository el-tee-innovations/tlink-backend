package za.co.tlinkportal.job.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import za.co.tlinkportal.common.enums.JobListingStatus;
import za.co.tlinkportal.common.enums.JobType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Job {

    @Id
    @GeneratedValue
    private Long id;

    private Long companyId; // from Company module

    private String title;
    private String description;
    private String location;

    @Enumerated(EnumType.STRING)
    private JobType jobType;

    @Enumerated(EnumType.STRING)
    private JobListingStatus status;

    private Integer minExperience;
    private Integer maxExperience;

    private LocalDateTime createdAt;
    private LocalDateTime expiresAt;

    @OneToMany(mappedBy = "job", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<JobSkill> skills = new ArrayList<>();
}
