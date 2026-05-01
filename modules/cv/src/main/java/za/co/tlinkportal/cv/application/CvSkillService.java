package za.co.tlinkportal.cv.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import za.co.tlinkportal.common.dto.cv.response.CvSkillDto;
import za.co.tlinkportal.cv.domain.CvSkill;
import za.co.tlinkportal.cv.infrastructure.CvSkillRepository;
import za.co.tlinkportal.cv.infrastructure.client.SkillClient;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CvSkillService {

    private final CvSkillRepository repository;
    private final SkillClient skillClient; // Feign

    public List<String> getSkillsByUserId(Long userId) {

        List<CvSkill> cvSkills = repository.findAllByUserId(userId).get();
        List<Long> skillIds = cvSkills.stream()
                .map(CvSkill::getSkillId)
                .toList();
        return skillClient.getSkillNames(skillIds).values().stream().toList();
    }

    public List<CvSkillDto> findBySkillIdIn(List<Long> skillIds){
        List<CvSkill> cvSkills = repository.findBySkillIdIn(skillIds).get();
        Map<Long, String> skillNames = skillClient.getSkillNames((skillIds));
        return cvSkills.stream()
                .map(cvSkill -> CvSkillDto.builder()
                        .userId(cvSkill.getUserId())
                        .skillName(skillNames.get(cvSkill.getSkillId()))
                        .build())
                .toList();
    }
}
