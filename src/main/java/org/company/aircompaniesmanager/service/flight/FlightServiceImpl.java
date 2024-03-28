package org.company.aircompaniesmanager.service.flight;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.company.aircompaniesmanager.dto.flight.FlightRequestDto;
import org.company.aircompaniesmanager.dto.flight.FlightResponseDto;
import org.company.aircompaniesmanager.dto.flight.FlightUpdateRequestDto;
import org.company.aircompaniesmanager.exception.EntityNotFoundException;
import org.company.aircompaniesmanager.mapper.FlightMapper;
import org.company.aircompaniesmanager.model.AirCompany;
import org.company.aircompaniesmanager.model.Airplane;
import org.company.aircompaniesmanager.model.Flight;
import org.company.aircompaniesmanager.model.Flight.Status;
import org.company.aircompaniesmanager.repository.FlightRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {
    private final FlightMapper flightMapper;
    private final FlightRepository flightRepository;

    @Override
    public List<FlightResponseDto> findAll(Pageable pageable) {
        return flightRepository.findAll(pageable).stream()
                .map(flightMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public FlightResponseDto findById(Long id) {
        Flight flight = flightRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Can't find flight with id: " + id)
        );
        return flightMapper.toDto(flight);
    }

    @Override
    public FlightResponseDto save(FlightRequestDto requestDto) {
        Flight flight = flightMapper.toEntity(requestDto);
        flight.setAirCompany(new AirCompany(requestDto.getAirCompanyId()));
        flight.setAirplane(new Airplane(requestDto.getAirplaneId()));
        flight.setStatus(Status.PENDING);
        flight.setCreationDate(LocalDateTime.now());
        return flightMapper.toDto(flightRepository.save(flight));
    }

    @Override
    @Transactional
    public FlightResponseDto updateStatus(Long id, FlightUpdateRequestDto requestDto) {
        Flight flight = flightRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Can't find flight with id: " + id)
        );
        Status status = requestDto.getStatus();
        flight.setStatus(status);
        switch (status) {
            case DELAYED:
                flight.setDelayStartTime(LocalDateTime.now());
                break;
            case ACTIVE:
                flight.setStartTime(LocalDateTime.now());
                break;
            case COMPLETED:
                flight.setEndTime(LocalDateTime.now());
                break;
            default: break;
        }
        return flightMapper.toDto(flightRepository.save(flight));
    }
}
