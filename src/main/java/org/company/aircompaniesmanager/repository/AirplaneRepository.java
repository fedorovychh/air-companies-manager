package org.company.aircompaniesmanager.repository;

import org.company.aircompaniesmanager.model.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirplaneRepository extends JpaRepository<Airplane, Long> {
}
