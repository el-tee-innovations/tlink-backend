package za.co.tlinkportal.user.application.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import za.co.tlinkportal.common.contracts.user.UserIdentityPort;
import za.co.tlinkportal.common.dto.user.request.CreateUserRequest;
import za.co.tlinkportal.common.dto.user.response.UserDto;
import za.co.tlinkportal.common.dto.user.response.UserResponse;
import za.co.tlinkportal.user.application.UserService;

@Service
@RequiredArgsConstructor
public class UserIdentityAdapter implements UserIdentityPort {

    private final UserService userApplicationService;

    @Override
    public UserResponse createUser(CreateUserRequest request) {
        return userApplicationService.createUser(request);
    }

    @Override
    public UserDto getUserById(Long id) {
        return userApplicationService.getUserById(id);
    }
}
