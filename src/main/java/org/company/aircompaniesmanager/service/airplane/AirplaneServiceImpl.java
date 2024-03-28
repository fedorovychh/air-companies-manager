package org.company.aircompaniesmanager.service.airplane;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.company.aircompaniesmanager.dto.airplane.AirplaneRequestDto;
import org.company.aircompaniesmanager.dto.airplane.AirplaneResponseDto;
import org.company.aircompaniesmanager.dto.airplane.AirplaneUpdateRequestDto;
import org.company.aircompaniesmanager.exception.EntityNotFoundException;
import org.company.aircompaniesmanager.mapper.AirplaneMapper;
import org.company.aircompaniesmanager.model.AirCompany;
import org.company.aircompaniesmanager.model.Airplane;
import org.company.aircompaniesmanager.repository.AirplaneRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AirplaneServiceImpl implements AirplaneService {
    private final AirplaneMapper airplaneMapper;
    private final AirplaneRepository airplaneRepository;

    @Override
    public AirplaneResponseDto findById(Long id) {
        Airplane airplane = airplaneRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Can't find airplane with id: " + id)
        );
        return airplaneMapper.toDto(airplane);
    }

    @Override
    public List<AirplaneResponseDto> findAll(Pageable pageable) {
        return airplaneRepository.findAll(pageable).stream()
                .map(airplaneMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public AirplaneResponseDto save(AirplaneRequestDto requestDto) {
        Airplane airplane = airplaneMapper.toEntity(requestDto);
        if (requestDto.getAirCompanyId() != null) {
            airplane.setAirCompany(new AirCompany(requestDto.getAirCompanyId()));
        }
        return airplaneMapper.toDto(airplaneRepository.save(airplane));
    }

    @Override
    @Transactional
    public AirplaneResponseDto updateCompany(Long id, AirplaneUpdateRequestDto requestDto) {
        Airplane airplane = airplaneRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Can't find airplane with id: " + id)
        );
        airplane.setAirCompany(new AirCompany(id));
        return airplaneMapper.toDto(airplaneRepository.save(airplane));
    }
}
