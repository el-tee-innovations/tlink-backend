package za.co.tlinkportal.auth.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthUser{

    @Id
    @GeneratedValue
    private long id;
    private long userId;
    private String email;
    private String passwordHash;

}
