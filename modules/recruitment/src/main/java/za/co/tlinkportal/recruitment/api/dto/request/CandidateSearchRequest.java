package za.co.tlinkportal.recruitment.api.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class CandidateSearchRequest {

    private List<Long> skillIds;
    private Integer minimumLevel;
    private String location;
    private Integer minYearsExperience;
}
