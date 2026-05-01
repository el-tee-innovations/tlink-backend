package za.co.tlinkportal.user.api.dto.request;

import lombok.Data;

@Data
public class UpdateUserRequest {

    private String firstName;
    private String middleName;
    private String lastName;
    private String cellphoneNumber;
    private String alternativeCellphoneNumber;
    private String profilePictureUrl;
}
