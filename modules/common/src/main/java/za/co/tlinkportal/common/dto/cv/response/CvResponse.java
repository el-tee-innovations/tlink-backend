package za.co.tlinkportal.common.dto.cv.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CvResponse {

    private Long userId;
    private String title;

    private String cvFileName;
    private String cvFilePath;

    private boolean visibleToRecruiters;

    private List<CvSkillDto> skills;
    private List<WorkExperienceDto> experiences;
    private List<QualificationDto> qualifications;
    private List<CertificationDto> certifications;
}
