package za.co.tlinkportal.skill.api.dto.request;

import lombok.Data;

@Data
public class CreateSkillRequest {
    private String name;
    private String category;
}
