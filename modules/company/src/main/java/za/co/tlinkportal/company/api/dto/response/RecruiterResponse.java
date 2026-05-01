package za.co.tlinkportal.company.api.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RecruiterResponse {
    private Long userId;
    private String userName;
}
