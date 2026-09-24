package za.co.tlinkportal.auth.application;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import za.co.tlinkportal.auth.api.dto.request.LoginRequest;
import za.co.tlinkportal.auth.api.dto.request.RegisterRequest;
import za.co.tlinkportal.auth.api.dto.response.LoginResponse;
import za.co.tlinkportal.auth.domain.AuthUser;
import za.co.tlinkportal.auth.infrastructure.AuthUserRepository;
import za.co.tlinkportal.auth.infrastructure.client.UserFeignClient;
import za.co.tlinkportal.common.contracts.user.UserIdentityPort;
import za.co.tlinkportal.common.dto.user.request.CreateUserRequest;
import za.co.tlinkportal.common.dto.user.response.UserDto;
import za.co.tlinkportal.common.dto.user.response.UserResponse;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final AuthUserRepository authUserRepository;
    private final UserIdentityPort userIdentityPort;

    @Transactional
    public void register(RegisterRequest registerRequest){

        // Create user in User Service
        CreateUserRequest createUserRequest = CreateUserRequest.builder()
                .firstName(registerRequest.getFirstName())
                .lastName(registerRequest.getLastName())
                .build();
        UserResponse userResponse = userIdentityPort.createUser(createUserRequest);

        // Create auth user
        AuthUser authUser = AuthUser.builder()
                .userId(userResponse.getId())
                .email(registerRequest.getEmail())
                .passwordHash(passwordEncoder.encode(registerRequest.getPassword()))
                .build();
        authUserRepository.save(authUser);

    }

    public LoginResponse login(LoginRequest request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(),
                            request.getPassword()
                    )
            );
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

        AuthUser authUser = authUserRepository.findByEmail(request.getEmail())
                .orElseThrow();
        UserDto userDto = userIdentityPort.getUserById(authUser.getUserId());

        List<String> roles = List.of("USER","RECRUITER","ADMIN"); // extend later

        String token = jwtUtil.generateToken(authUser.getEmail(), roles);

        LoginResponse.User user = LoginResponse.User.builder()
                .userId(authUser.getUserId())
                .email(authUser.getEmail())
                .firstName(userDto.getFirstName())
                .middleName(userDto.getMiddleName())
                .lastName(userDto.getLastName())
                .role("ADMIN") // extend later
                .build();

        return LoginResponse.builder()
                .accessToken(token)
                .user(user)
                .build();
    }
}
