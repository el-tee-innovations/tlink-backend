package za.co.tlinkportal.user.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import za.co.tlinkportal.common.dto.user.request.CreateUserRequest;
import za.co.tlinkportal.common.dto.user.response.UserResponse;
import za.co.tlinkportal.user.api.dto.response.UserDto;
import za.co.tlinkportal.user.application.UserService;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping
    public UserResponse create(@RequestBody CreateUserRequest request) {
        return service.createUser(request);
    }

    @GetMapping("/{id}")
    public UserResponse get(@PathVariable Long id) {
        return service.getUser(id);
    }

    // 🔥 IMPORTANT for Feign
    @GetMapping("/internal/{id}")
    public UserDto getInternal(@PathVariable Long id) {
        return service.getUserDto(id);
    }
}
