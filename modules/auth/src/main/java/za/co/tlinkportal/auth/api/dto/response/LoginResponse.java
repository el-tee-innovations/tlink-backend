package za.co.tlinkportal.auth.api.dto.response;

import lombok.*;

import java.util.List;

@Builder
@Getter
@AllArgsConstructor
public class LoginResponse {

    private String accessToken;
    private User user;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class User {

        private Long userId;
        private String email;
        private String firstName;
        private String middleName;
        private String lastName;
        private String role;
    }
}
