package za.co.tlinkportal.recruitment.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.tlinkportal.recruitment.api.dto.request.CandidateSearchRequest;
import za.co.tlinkportal.recruitment.api.dto.response.CandidateSearchResponse;
import za.co.tlinkportal.recruitment.application.CandidateSearchService;

import java.util.List;

@RestController
@RequestMapping("/api/recruitment/candidates")
@RequiredArgsConstructor
public class CandidateSearchController {

    private final CandidateSearchService service;

    @PostMapping("/search")
    public List<CandidateSearchResponse> search(
            @RequestBody CandidateSearchRequest request) {
        return service.searchCandidates(request);
    }
}
