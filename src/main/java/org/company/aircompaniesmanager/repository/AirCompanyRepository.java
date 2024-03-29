package org.company.aircompaniesmanager.repository;

import java.util.Optional;
import org.company.aircompaniesmanager.model.AirCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirCompanyRepository extends JpaRepository<AirCompany, Long> {
    Optional<AirCompany> findByName(String name);
}
