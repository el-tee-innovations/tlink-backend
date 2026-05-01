package za.co.tlinkportal.job.api.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JobSkillRequest {

    private Long skillId;
    private int requiredLevel;
    private boolean mandatory;
}