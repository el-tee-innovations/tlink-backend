package za.co.tlinkportal.recruitment.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import za.co.tlinkportal.common.dto.cv.response.CvSkillDto;
import za.co.tlinkportal.common.dto.job.response.JobDto;
import za.co.tlinkportal.common.dto.cv.response.CvResponse;
import za.co.tlinkportal.common.dto.job.response.JobSkillDto;
import za.co.tlinkportal.recruitment.api.dto.response.CandidateSearchResponse;
import za.co.tlinkportal.recruitment.infrastructure.client.CvClient;
import za.co.tlinkportal.recruitment.infrastructure.client.JobClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CandidateMatchingService {

    private final JobClient jobClient;
    private final CvClient cvClient;

    public double match(Long jobId, Long userId) {

        JobDto job = jobClient.getJob(jobId);
        CvResponse cv = cvClient.getByUserId(userId);

        double skillScore = calculateSkillScore(job, cv);
        double experienceScore = calculateExperienceScore(job, cv);
        double bonusScore = calculateBonusScore(job, cv);
        double completenessScore = calculateCompleteness(cv);
        double activityScore = calculateActivity(cv);

        return (skillScore * 0.5 +
                experienceScore * 0.2 +
                bonusScore * 0.15 +
                completenessScore * 0.1 +
                activityScore * 0.05)* 100;
    }

    public List<CandidateSearchResponse> rankCandidates(Long jobId, List<Long> userIds) {

        return userIds.stream()
                .map(userId -> CandidateSearchResponse.builder().userId(userId).matchScore(match(jobId, userId)).build()
                )
                .sorted((a, b) -> Double.compare(b.getMatchScore(), a.getMatchScore()))
                .toList();
    }

    private double calculateActivity(CvResponse cv) {
        return 0;
    }

    private double calculateCompleteness(CvResponse cv) {
        int filledFields = 0;

//        if (cv.getSummary() != null) filledFields++;
        if (!cv.getSkills().isEmpty()) filledFields++;
        if (!cv.getExperiences().isEmpty()) filledFields++;
        if (!cv.getQualifications().isEmpty()) filledFields++;

        return filledFields / 3.0;
    }

    private double calculateBonusScore(JobDto job, CvResponse cv) {
        return 0;
    }

    private double calculateExperienceScore(JobDto job, CvResponse cv) {
        return 0; // TODO: implement experience scoring
    }

    private double calculateSkillScore(JobDto job, CvResponse cv) {
        double score = 0;

        if (job.getSkills() != null && !job.getSkills().isEmpty()) {
            for (JobSkillDto jobSkill : job.getSkills()) {

                CvSkillDto candidateSkill = findCandidateSkill(jobSkill.getSkillId());

                if (candidateSkill != null) {

                    double levelMatch = (double) candidateSkill.getLevel() / jobSkill.getRequiredLevel();
                    levelMatch = Math.min(levelMatch, 1.0);

                    if (jobSkill.isMandatory()) {
                        score += levelMatch * 2;
                    } else {
                        score += levelMatch;
                    }

                } else if (jobSkill.isMandatory()) {
                    return 0; // FAIL FAST 🚨
                }
            }
        }else {
            return 0;
        }

        double maxScore = job.getSkills().size() * 2;
        return  score / maxScore;
    }

    private CvSkillDto findCandidateSkill(Long skillId) {
        return cvClient.getByUserId(skillId)
                .getSkills()
                .stream()
                .filter(s -> s.getSkillId().equals(skillId))
                .findFirst()
                .orElse(null);
    }
}