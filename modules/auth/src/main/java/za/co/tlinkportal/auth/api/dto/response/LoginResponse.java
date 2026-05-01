package za.co.tlinkportal.auth.api.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class LoginResponse {

    private String token;
    private Long userId;
    private String email;
    private String firstName;
    private String middleName;
    private String lastName;
    private List<String> roles;
}
