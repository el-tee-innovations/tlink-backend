package za.co.tlinkportal.recruitment.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.tlinkportal.recruitment.domain.SavedCandidate;

import java.util.List;

public interface SavedCandidateRepository extends JpaRepository<SavedCandidate, Long> {

    List<SavedCandidate> findByRecruiterId(Long recruiterId);

    boolean existsByRecruiterIdAndCandidateId(Long recruiterId, Long candidateId);

    void removeByRecruiterIdAndCandidateId(Long recruiterId, Long candidateId);
}