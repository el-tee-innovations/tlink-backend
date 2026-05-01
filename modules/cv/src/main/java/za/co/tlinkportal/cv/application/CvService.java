package za.co.tlinkportal.cv.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.tlinkportal.common.dto.cv.request.CvUpdateSkillsRequest;
import za.co.tlinkportal.common.dto.cv.response.CvSkillDto;
import za.co.tlinkportal.cv.api.dto.request.CvCreateRequest;
import za.co.tlinkportal.common.dto.cv.response.CvResponse;
import za.co.tlinkportal.cv.domain.Cv;
import za.co.tlinkportal.cv.domain.CvSkill;
import za.co.tlinkportal.cv.infrastructure.CvRepository;
import za.co.tlinkportal.cv.infrastructure.client.SkillClient;

import java.util.List;
import java.util.Map;

@Service
public class CvService {

    private final CvRepository cvRepository;
    private final SkillClient skillClient; // optional integration

    @Autowired
    public CvService(CvRepository cvRepository, SkillClient skillClient) {
        this.cvRepository = cvRepository;
        this.skillClient = skillClient;
    }

    public CvResponse getCvByUserId(Long userId) {
        Cv cv = cvRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("CV not found"));

        return mapToResponse(cv);
    }

    public Long createCv(CvCreateRequest request) {
        Cv cv = new Cv();
        cv.setUserId(request.getUserId());
        cv.setTitle(request.getTitle());

        return cvRepository.save(cv).getId();
    }

    public void updateSkills(Long userId, CvUpdateSkillsRequest request) {

        Cv cv = cvRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("CV not found"));

        List<CvSkill> skills = request.getSkills()
                .stream()
                .map(s -> {
                    CvSkill skill = new CvSkill();
                    skill.setSkillId(s.getSkillId());
                    skill.setLevel(s.getLevel());
                    skill.setYearsOfExperience(s.getYearsOfExperience());
                    return skill;
                })
                .toList();

        cv.setSkills(skills);

        cvRepository.save(cv);
    }

    private CvResponse mapToResponse(Cv cv) {

        List<Long> skillIds = cv.getSkills()
                .stream()
                .map(CvSkill::getSkillId)
                .toList();

        Map<Long, String> skillNames = skillClient.getSkillNames(skillIds);

        List<CvSkillDto> skills = cv.getSkills().stream()
                .map(s -> {
                    return CvSkillDto.builder().
                            skillId(s.getSkillId()).
                            skillName(skillNames.get(s.getSkillId())).
                            level(s.getLevel()).
                            yearsOfExperience(s.getYearsOfExperience()).userId(s.getUserId()).build();
                })
                .toList();

        return CvResponse.builder()
                .userId(cv.getUserId())
                .cvFileName(cv.getCvFileName())
                .cvFilePath(cv.getCvFilePath())
                .skills(skills)
                .build();
    }

    public List<Long> getSkillIdsByUserId(Long userId) {
        Cv cv = cvRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("CV not found"));

        return cv.getSkills()
                .stream()
                .map(CvSkill::getSkillId)
                .toList();
    }
}
