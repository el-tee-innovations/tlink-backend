package za.co.tlinkportal.skill.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.tlinkportal.skill.domain.Skill;

import java.util.List;
import java.util.Optional;

public interface SkillRepository extends JpaRepository<Skill, Long> {
    Optional<Skill> findByName(String name);
    Optional<Skill> findById(Long id);
    Optional<Skill> findAllById(List<Long> id);
}
