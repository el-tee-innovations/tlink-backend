package za.co.tlinkportal.recruitment.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import za.co.tlinkportal.common.dto.cv.response.CvSkillDto;
import za.co.tlinkportal.common.dto.user.response.UserDto;
import za.co.tlinkportal.recruitment.api.dto.request.CandidateSearchRequest;
import za.co.tlinkportal.recruitment.api.dto.response.CandidateSearchResponse;
import za.co.tlinkportal.recruitment.infrastructure.client.CvClient;
import za.co.tlinkportal.recruitment.infrastructure.client.SkillClient;
import za.co.tlinkportal.recruitment.infrastructure.client.UserClient;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CandidateSearchService {

    private final CvClient cvClient;
    private final UserClient userClient;
    private final SkillClient skillClient;

    public List<CandidateSearchResponse> searchCandidates(CandidateSearchRequest request) {

        // 1. Get all CV skills matching required skills
        List<CvSkillDto> cvSkills =
                cvClient.findCandidatesBySkills(request.getSkillIds());

        // 2. Group by userId
        Map<Long, List<CvSkillDto>> grouped =
                cvSkills.stream()
                        .collect(Collectors.groupingBy(CvSkillDto::getUserId));

        // 3. Build response
        return grouped.entrySet().stream()
                .map(entry -> {

                    Long userId = entry.getKey();
                    List<CvSkillDto> skills = entry.getValue();

                    // Fetch user
                    UserDto user = userClient.getUser(userId);

                    // Fetch skill names
                    List<String> skillNames = skillClient.getSkillNames(
                            skills.stream()
                                    .map(CvSkillDto::getSkillId)
                                    .toList()
                    ).values().stream().toList();

                    // Simple scoring
                    int score = skills.size(); // can improve later

                    return CandidateSearchResponse.builder()
                            .userId(userId)
                            .firstName(user.getFirstName())
                            .middleName(user.getMiddleName())
                            .lastName(user.getLastName())
                            .matchedSkills(skillNames)
                            .matchScore(score)
                            .build();
                })
                .sorted(Comparator.comparingDouble(CandidateSearchResponse::getMatchScore).reversed())
                .toList();
    }
}
