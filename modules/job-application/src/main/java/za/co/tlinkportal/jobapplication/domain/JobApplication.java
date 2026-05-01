package za.co.tlinkportal.jobapplication.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import za.co.tlinkportal.common.enums.JobApplicationStatus;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobApplication {

    @Id
    @GeneratedValue
    private Long id;

    private Long jobId;     // Job module
    private Long userId;    // User module
    private Long companyId; // derived from Job

    @Enumerated(EnumType.STRING)
    private JobApplicationStatus status;

    private LocalDateTime appliedAt;
    private LocalDateTime lastUpdatedAt;

    private String coverLetter;

    // Optional: recruiter notes
    private String recruiterNotes;
}
