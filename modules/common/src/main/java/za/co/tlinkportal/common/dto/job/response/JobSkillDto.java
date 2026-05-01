package za.co.tlinkportal.common.dto.job.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JobSkillDto {
    private Long skillId;
    private int requiredLevel;
    private boolean mandatory;
}
