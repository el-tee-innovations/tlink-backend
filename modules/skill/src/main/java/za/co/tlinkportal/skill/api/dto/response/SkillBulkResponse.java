package za.co.tlinkportal.skill.api.dto.response;

import lombok.Data;

import java.util.Map;

@Data
public class SkillBulkResponse {
    private Map<Long, String> skills;
}