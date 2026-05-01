package za.co.tlinkportal.job.api.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class JobSkillResponse {

    private Long skillId;
    private int requiredLevel;
    private boolean mandatory;
}