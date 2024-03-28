package org.company.aircompaniesmanager.repository;

import org.company.aircompaniesmanager.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
}
