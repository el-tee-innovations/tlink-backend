package za.co.tlinkportal.user.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue
    private long id;

    //personal information
    private String firstName;
    private String middleName;
    private String lastName;
    private String cellphoneNumber;
    private String alternativeCellphoneNumber;

    //Profile
    private String profilePictureUrl;
    private boolean acceptedPrivacyPolicy;
    private LocalDate privacyPolicyAcceptedDate;
    private LocalDate createdAt;
}
