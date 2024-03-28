package org.company.aircompaniesmanager.repository;

import java.time.LocalDateTime;
import java.util.List;
import org.company.aircompaniesmanager.model.Flight;
import org.company.aircompaniesmanager.model.Flight.Status;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> findAllByAirCompanyIdAndStatus(Long id, Status status, Pageable pageable);

    @Query("SELECT f FROM Flight f WHERE (f.startTime > :localDateTime) AND (f.status = :status)")
    List<Flight> findAllExpired(LocalDateTime localDateTime, Status status, Pageable pageable);
}
