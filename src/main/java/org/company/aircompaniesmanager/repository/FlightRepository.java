package org.company.aircompaniesmanager.repository;

import java.util.List;
import org.company.aircompaniesmanager.model.Flight;
import org.company.aircompaniesmanager.model.Flight.Status;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> findAllByAirCompanyIdAndStatus(Long id, Status status, Pageable pageable);
}
