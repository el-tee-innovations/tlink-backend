package za.co.tlinkportal.auth.api.dto.request;

import lombok.Data;

@Data
public class RegisterRequest {
    private String email;
    private String firstName;
    private String middleName;
    private String lastName;
    private String password;
    private String cellphoneNumber;
    private String alternativeCellphoneNumber;
}
