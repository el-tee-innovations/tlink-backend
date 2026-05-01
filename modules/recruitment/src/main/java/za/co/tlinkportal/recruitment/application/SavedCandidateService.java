package za.co.tlinkportal.recruitment.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import za.co.tlinkportal.recruitment.api.dto.request.SaveCandidateRequest;
import za.co.tlinkportal.recruitment.domain.SavedCandidate;
import za.co.tlinkportal.recruitment.infrastructure.SavedCandidateRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SavedCandidateService {

    private final SavedCandidateRepository repository;

    public void save(Long recruiterId, SaveCandidateRequest request) {

        if (repository.existsByRecruiterIdAndCandidateId(
                recruiterId, request.getCandidateId())) {
            return;
        }

        repository.save(SavedCandidate.builder()
                .recruiterId(recruiterId)
                .candidateId(request.getCandidateId())
                .note(request.getNote())
                .savedAt(LocalDateTime.now())
                .build());
    }

    public List<Long> getSavedCandidates(Long recruiterId) {
        return repository.findByRecruiterId(recruiterId)
                .stream()
                .map(SavedCandidate::getCandidateId)
                .toList();
    }

    public void removeCandidate(Long recruiterId, Long candidateId) {
        repository.removeByRecruiterIdAndCandidateId(recruiterId, candidateId);

    }
}
