package za.co.tlinkportal.cv.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.tlinkportal.cv.domain.CvSkill;

import java.util.List;
import java.util.Optional;

@Repository
public interface CvSkillRepository extends JpaRepository<CvSkill, Long> {
    Optional<List<CvSkill>> findAllByUserId(Long userId);
    Optional<List<CvSkill>> findBySkillIdIn(List<Long> skillIds);
}
