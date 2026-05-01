package za.co.tlinkportal.common.dto.cv.request;

import lombok.Data;

import java.util.List;

@Data
public class CvUpdateSkillsRequest {

    private Long userId;

    private List<CvSkillRequest> skills;

    @Data
    public static class CvSkillRequest {
        private Long skillId;  // from Skill module
        private int level;
        private int yearsOfExperience;
    }
}
