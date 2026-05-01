package za.co.tlinkportal.recruitment.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import za.co.tlinkportal.common.enums.JobRecruitmentStatus;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Recruitment {

    @Id
    @GeneratedValue
    private Long id;

    private Long jobId;
    private Long recruiterId;
    private Long candidateId;

    @Enumerated(EnumType.STRING)
    private JobRecruitmentStatus status;

    private String message;

    private LocalDateTime createdAt;
}
