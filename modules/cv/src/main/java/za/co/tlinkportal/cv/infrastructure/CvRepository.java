package za.co.tlinkportal.cv.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.tlinkportal.cv.domain.Cv;

import java.util.Optional;

@Repository
public interface CvRepository extends JpaRepository<Cv, Long> {
    Optional<Cv> findByUserId(Long userId);
}
