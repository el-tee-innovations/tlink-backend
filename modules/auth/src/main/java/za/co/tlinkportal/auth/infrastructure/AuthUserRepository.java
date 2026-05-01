package za.co.tlinkportal.auth.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.tlinkportal.auth.domain.AuthUser;

import java.util.Optional;

public interface AuthUserRepository extends JpaRepository<AuthUser, Long> {
    Optional<AuthUser> findByEmail(String email);
}
