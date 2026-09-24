package za.co.tlinkportal.user.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import za.co.tlinkportal.common.dto.user.request.CreateUserRequest;
import za.co.tlinkportal.common.dto.user.response.UserDto;
import za.co.tlinkportal.common.dto.user.response.UserResponse;
import za.co.tlinkportal.user.domain.User;
import za.co.tlinkportal.user.infrastructure.UserRepository;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public UserResponse createUser(CreateUserRequest request) {

        User user = User.builder()
                .firstName(request.getFirstName())
                .middleName(request.getMiddleName())
                .lastName(request.getLastName())
                .cellphoneNumber(request.getCellphoneNumber())
                .createdAt(LocalDate.now())
                .build();
        return map(repository.save(user));
    }

    public UserDto getUserById(Long id) {
        return toDto(repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found")));
    }

    public UserDto getUserDto(Long id) {
        User user = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return toDto(user);
    }

    private UserResponse map(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .cellphoneNumber(user.getCellphoneNumber())
                .profilePictureUrl(user.getProfilePictureUrl())
                .build();
    }

    private UserDto toDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .cellphoneNumber(user.getCellphoneNumber())
                .profilePictureUrl(user.getProfilePictureUrl())
                .build();
    }
}
