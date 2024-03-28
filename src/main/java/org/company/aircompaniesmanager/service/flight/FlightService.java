package org.company.aircompaniesmanager.service.flight;

import java.util.List;
import org.company.aircompaniesmanager.dto.flight.FlightRequestDto;
import org.company.aircompaniesmanager.dto.flight.FlightResponseDto;
import org.company.aircompaniesmanager.dto.flight.FlightUpdateRequestDto;
import org.springframework.data.domain.Pageable;

public interface FlightService {
    List<FlightResponseDto> findAll(Pageable pageable);

    List<FlightResponseDto> findAllByCompanyName(
            String companyName,
            String statusString,
            Pageable pageable
    );

    FlightResponseDto findById(Long id);

    FlightResponseDto save(FlightRequestDto requestDto);

    FlightResponseDto updateStatus(Long id, FlightUpdateRequestDto requestDto);
}
