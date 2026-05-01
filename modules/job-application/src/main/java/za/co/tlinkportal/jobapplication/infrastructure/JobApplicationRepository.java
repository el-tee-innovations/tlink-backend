package za.co.tlinkportal.jobapplication.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.tlinkportal.jobapplication.domain.JobApplication;

import java.util.List;
import java.util.Optional;

public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {

    List<JobApplication> findByUserId(Long userId);

    List<JobApplication> findByJobId(Long jobId);

    List<JobApplication> findByCompanyId(Long companyId);

    Optional<JobApplication> findByJobIdAndUserId(Long jobId, Long userId);
}
