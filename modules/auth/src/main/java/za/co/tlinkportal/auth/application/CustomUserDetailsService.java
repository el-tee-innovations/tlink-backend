package za.co.tlinkportal.auth.application;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import za.co.tlinkportal.auth.domain.AuthUser;
import za.co.tlinkportal.auth.infrastructure.AuthUserRepository;
import za.co.tlinkportal.auth.infrastructure.client.UserFeignClient;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserFeignClient userFeignClient;
    private final AuthUserRepository AuthUserRepository;

    @Override
    public UserDetails loadUserByUsername(String email) {

        AuthUser authUser = AuthUserRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return new org.springframework.security.core.userdetails.User(
                authUser.getEmail(),
                authUser.getPasswordHash(),
                List.of(new SimpleGrantedAuthority("JOB_SEEKER")) // extend later
        );
    }
}