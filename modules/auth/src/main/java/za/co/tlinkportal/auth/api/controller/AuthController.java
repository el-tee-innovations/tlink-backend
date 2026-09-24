package za.co.tlinkportal.auth.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.tlinkportal.auth.api.dto.request.LoginRequest;
import za.co.tlinkportal.auth.api.dto.request.RegisterRequest;
import za.co.tlinkportal.auth.api.dto.response.LoginResponse;
import za.co.tlinkportal.auth.application.AuthService;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }

    @PostMapping("/register")
    public void register(@RequestBody RegisterRequest request) {
        try {
            authService.register(request);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
