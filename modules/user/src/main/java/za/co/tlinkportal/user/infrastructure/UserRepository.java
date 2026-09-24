package za.co.tlinkportal.user.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.tlinkportal.user.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

}
