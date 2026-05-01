package za.co.tlinkportal.auth.application;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import za.co.tlinkportal.auth.domain.AuthUser;
import za.co.tlinkportal.auth.infrastructure.AuthUserRepository;
import za.co.tlinkportal.auth.infrastructure.client.UserClient;
import za.co.tlinkportal.common.dto.user.response.UserDto;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserClient userClient;
    private final AuthUserRepository AuthUserRepository;

    @Override
    public UserDetails loadUserByUsername(String email) {

        AuthUser authUser = AuthUserRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        UserDto userDto = userClient.getUserById(authUser.getUserId());

        return new org.springframework.security.core.userdetails.User(
                userDto.getEmail(),
                authUser.getPasswordHash(),
                List.of(new SimpleGrantedAuthority("ROLE_USER")) // extend later
        );
    }
}