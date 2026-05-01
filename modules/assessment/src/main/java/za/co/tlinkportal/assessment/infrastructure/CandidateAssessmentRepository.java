package za.co.tlinkportal.assessment.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.tlinkportal.assessment.domain.CandidateAssessment;

@Repository
public interface CandidateAssessmentRepository extends JpaRepository<CandidateAssessment, Long> {
}
