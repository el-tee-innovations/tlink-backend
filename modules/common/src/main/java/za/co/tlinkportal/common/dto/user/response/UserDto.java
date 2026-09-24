package za.co.tlinkportal.common.dto.user.response;

import jdk.jshell.Snippet;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserDto {

    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String cellphoneNumber;
    private String profilePictureUrl;
}
