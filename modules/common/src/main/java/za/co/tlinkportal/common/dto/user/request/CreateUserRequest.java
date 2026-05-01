package za.co.tlinkportal.common.dto.user.request;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class CreateUserRequest {

    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String cellphoneNumber;

    private String profilePictureUrl;
    private boolean acceptedPrivacyPolicy;
    private LocalDate privacyPolicyAcceptedDate;
    private LocalDate createdAt;
}
