package za.co.tlinkportal.common.contracts.user;

import za.co.tlinkportal.common.dto.user.request.CreateUserRequest;
import za.co.tlinkportal.common.dto.user.response.UserDto;
import za.co.tlinkportal.common.dto.user.response.UserResponse;

public interface UserIdentityPort {

    UserResponse createUser(CreateUserRequest request);

    UserDto getUserById(Long id);
}
