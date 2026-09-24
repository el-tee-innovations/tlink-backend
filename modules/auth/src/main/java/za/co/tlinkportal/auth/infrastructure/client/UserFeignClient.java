package za.co.tlinkportal.auth.infrastructure.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import za.co.tlinkportal.common.dto.user.request.CreateUserRequest;
import za.co.tlinkportal.common.dto.user.response.UserDto;
import za.co.tlinkportal.common.dto.user.response.UserResponse;

@FeignClient(name = "auth-user-service", url = "http://localhost:8080")
public interface UserFeignClient {

    @GetMapping("/api/users/internal/{id}")
    UserDto getUserById(@PathVariable("id") Long id);

    @PostMapping("/api/users")
    UserResponse createUser(@RequestBody CreateUserRequest createUserRequest);
}
