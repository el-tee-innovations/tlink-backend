package za.co.tlinkportal.recruitment.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.tlinkportal.recruitment.domain.Recruitment;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface RecruitmentRepository extends JpaRepository<Recruitment, Long> {

    List<Recruitment> findByCandidateId(Long candidateId);
    List<Recruitment> findByRecruiterId(Long recruiterId);
    Optional<Recruitment> findByJobIdAndCandidateId(Long jobId, Long candidateId);
    Optional<Recruitment> findByRecruiterIdAndCandidateId(Long recruiterId, Long candidateId);
}
