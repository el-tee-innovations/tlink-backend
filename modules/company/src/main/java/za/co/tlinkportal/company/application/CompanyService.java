package za.co.tlinkportal.company.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import za.co.tlinkportal.company.api.dto.request.CreateCompanyRequest;
import za.co.tlinkportal.company.api.dto.response.CompanyResponse;
import za.co.tlinkportal.company.domain.Company;
import za.co.tlinkportal.company.infrastructure.CompanyRepository;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyResponse createCompany(CreateCompanyRequest request) {

        Company company = Company.builder()
                .name(request.getName())
                .description(request.getDescription())
                .website(request.getWebsite())
                .industry(request.getIndustry())
                .location(request.getLocation())
                .createdAt(LocalDateTime.now())
                .active(true)
                .logoUrl(request.getLogoUrl())
                .build();

        return map(companyRepository.save(company));
    }

    private CompanyResponse map(Company company) {
        return CompanyResponse.builder()
                .id(company.getId())
                .name(company.getName())
                .description(company.getDescription())
                .website(company.getWebsite())
                .industry(company.getIndustry())
                .location(company.getLocation())
                .build();
    }
}
