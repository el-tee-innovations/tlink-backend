package za.co.tlinkportal.job.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.tlinkportal.common.enums.JobListingStatus;
import za.co.tlinkportal.job.domain.Job;

import java.util.List;

public interface JobRepository extends JpaRepository<Job, Long> {

    List<Job> findByCompanyId(Long companyId);

    List<Job> findByStatus(JobListingStatus status);
}
