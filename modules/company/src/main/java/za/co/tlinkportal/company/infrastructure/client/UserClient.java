package za.co.tlinkportal.company.infrastructure.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import za.co.tlinkportal.common.dto.user.response.UserDto;

@FeignClient(name = "company-user-service", url = "http://localhost:8080")
public interface UserClient {

    @GetMapping("/api/users/internal/{id}")
    UserDto getUserById(@PathVariable("id") Long id);
}
