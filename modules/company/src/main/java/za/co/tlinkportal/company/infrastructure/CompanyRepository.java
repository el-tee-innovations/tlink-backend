package za.co.tlinkportal.company.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.tlinkportal.company.domain.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
