package za.co.tlinkportal.recruitment.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import za.co.tlinkportal.common.dto.job.response.JobDto;
import za.co.tlinkportal.common.dto.user.response.UserDto;
import za.co.tlinkportal.common.enums.JobRecruitmentStatus;
import za.co.tlinkportal.recruitment.api.dto.request.RecruitCandidateRequest;
import za.co.tlinkportal.recruitment.api.dto.response.RecruitmentResponse;
import za.co.tlinkportal.recruitment.domain.Recruitment;
import za.co.tlinkportal.recruitment.infrastructure.RecruitmentRepository;
import za.co.tlinkportal.recruitment.infrastructure.client.JobClient;
import za.co.tlinkportal.recruitment.infrastructure.client.UserClient;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RecruitmentService {

    private final RecruitmentRepository repository;
    private final JobClient jobClient;
    private final UserClient userClient;

    public void recruit(Long recruiterId, RecruitCandidateRequest request) {

        // prevent duplicate recruitment
        repository.findByJobIdAndCandidateId(
                request.getJobId(), request.getCandidateId()
        ).ifPresent(r -> {
            throw new RuntimeException("Candidate already recruited for this job");
        });

        Recruitment recruitment = Recruitment.builder()
                .jobId(request.getJobId())
                .recruiterId(recruiterId)
                .candidateId(request.getCandidateId())
                .status(JobRecruitmentStatus.INVITED)
                .message(request.getMessage())
                .createdAt(LocalDateTime.now())
                .build();

        repository.save(recruitment);
    }

    public List<RecruitmentResponse> getRecruitmentsForCandidate(Long candidateId) {

        return repository.findByCandidateId(candidateId)
                .stream()
                .map(r -> {

                    JobDto job = jobClient.getJob(r.getJobId());
                    UserDto recruiter = userClient.getUser(r.getRecruiterId());

                    return RecruitmentResponse.builder()
                            .id(r.getId())
                            .jobId(r.getJobId())
                            .jobTitle(job.getTitle())
                            .candidateId(candidateId)
                            .candidateName(recruiter.getFirstName())
                            .status(r.getStatus())
                            .build();
                }).toList();
    }

    public void cancelInvite(Long recruiterId, Long candidateId) {

        List<Recruitment> recruitments = repository.findByRecruiterIdAndCandidateId(recruiterId,candidateId)
                .stream()
                .filter(r -> r.getCandidateId().equals(candidateId))
                .toList();

        if (recruitments.isEmpty()) {
            throw new RuntimeException("No recruitment found for this candidate");
        }

        recruitments.forEach(repository::delete);
    }
}