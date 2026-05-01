package za.co.tlinkportal.common.dto.user.response;

import lombok.Data;

@Data
public class UserDto {

    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
}
