package za.co.tlinkportal.skill.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import za.co.tlinkportal.skill.api.dto.request.CreateSkillRequest;
import za.co.tlinkportal.skill.api.dto.response.SkillBulkResponse;
import za.co.tlinkportal.skill.api.dto.response.SkillResponse;
import za.co.tlinkportal.skill.domain.Skill;
import za.co.tlinkportal.skill.infrastructure.SkillRepository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SkillService {

    private final SkillRepository skillRepository;

    public SkillResponse create(CreateSkillRequest request) {

        Skill skill = new Skill();
        skill.setName(request.getName());
        skill.setCategory(request.getCategory());

        Skill saved = skillRepository.save(skill);

        SkillResponse response = new SkillResponse();
        response.setId(saved.getId());
        response.setName(saved.getName());
        response.setCategory(saved.getCategory());

        return response;
    }

    public List<Skill> findAllByIds(List<Long> ids) {
        return skillRepository.findAllById(ids).stream().toList();
    }

    public SkillBulkResponse getSkillNames(List<Long> ids) {

        Map<Long, String> map = skillRepository.findAllById(ids)
                .stream()
                .collect(Collectors.toMap(
                        Skill::getId,
                        Skill::getName
                ));

        SkillBulkResponse response = new SkillBulkResponse();
        response.setSkills(map);

        return response;
    }
}
