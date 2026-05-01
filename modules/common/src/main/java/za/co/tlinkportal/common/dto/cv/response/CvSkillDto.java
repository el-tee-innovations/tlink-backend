package za.co.tlinkportal.common.dto.cv.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CvSkillDto {

    private Long skillId;
    private Long userId;
    private String skillName;
    private int level;
    private int yearsOfExperience;
}
