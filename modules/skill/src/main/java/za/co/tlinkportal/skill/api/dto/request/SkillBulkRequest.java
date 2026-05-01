package za.co.tlinkportal.skill.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class SkillBulkRequest {
    private List<Long> ids;
}
