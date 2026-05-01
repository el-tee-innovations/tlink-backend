package za.co.tlinkportal.common.dto.job.response;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class JobDto {
    private String Title;
    private long ApplicationsCount;
    private String CompanyName;
    private long CompanyId;
    private String Location;
    private boolean IsActive;
    private List<JobSkillDto> Skills;
    private LocalDateTime PostedDate;
}
