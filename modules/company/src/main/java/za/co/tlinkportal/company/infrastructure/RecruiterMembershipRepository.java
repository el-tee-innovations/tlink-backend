package za.co.tlinkportal.company.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.tlinkportal.company.domain.RecruiterMembership;

import java.util.List;
import java.util.Optional;

public interface RecruiterMembershipRepository
        extends JpaRepository<RecruiterMembership, Long> {

    List<RecruiterMembership> findByCompanyId(Long companyId);

    List<RecruiterMembership> findByUserId(Long userId);

    Optional<RecruiterMembership> findByUserIdAndCompanyId(Long userId, Long companyId);
}
