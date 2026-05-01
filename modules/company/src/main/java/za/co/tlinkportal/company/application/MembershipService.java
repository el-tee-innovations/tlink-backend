package za.co.tlinkportal.company.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import za.co.tlinkportal.common.dto.user.response.UserDto;
import za.co.tlinkportal.company.api.dto.request.AddRecruiterRequest;
import za.co.tlinkportal.company.api.dto.response.RecruiterResponse;
import za.co.tlinkportal.company.domain.RecruiterMembership;
import za.co.tlinkportal.company.infrastructure.RecruiterMembershipRepository;
import za.co.tlinkportal.company.infrastructure.client.UserClient;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MembershipService {

    private final RecruiterMembershipRepository repository;
    private final UserClient userClient; // Feign

    public void addRecruiter(Long companyId, AddRecruiterRequest request) {

        RecruiterMembership membership = RecruiterMembership.builder()
                .companyId(companyId)
                .userId(request.getUserId())
                .active(true)
                .joinedAt(LocalDateTime.now())
                .build();

        repository.save(membership);
    }

    public List<RecruiterResponse> getCompanyRecruiters(Long companyId) {

        List<RecruiterMembership> memberships =
                repository.findByCompanyId(companyId);

        return memberships.stream().map(m -> {

            UserDto user = userClient.getUserById(m.getUserId());

            return RecruiterResponse.builder()
                    .userId(m.getUserId())
                    .userName(user.getEmail())
                    .build();
        }).toList();
    }
}
