package za.co.tlinkportal.recruitment.api.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CandidateSearchResponse {

    private Long userId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private List<String> matchedSkills;
    private double matchScore;
}
