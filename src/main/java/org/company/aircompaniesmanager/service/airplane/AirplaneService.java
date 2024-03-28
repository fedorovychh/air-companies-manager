package org.company.aircompaniesmanager.service.airplane;

import java.util.List;
import org.company.aircompaniesmanager.dto.airplane.AirplaneRequestDto;
import org.company.aircompaniesmanager.dto.airplane.AirplaneResponseDto;
import org.company.aircompaniesmanager.dto.airplane.AirplaneUpdateRequestDto;

public interface AirplaneService {
    AirplaneResponseDto findById(Long id);

    List<AirplaneResponseDto> findAll();

    AirplaneResponseDto save(AirplaneRequestDto requestDto);

    AirplaneResponseDto updateCompany(Long id, AirplaneUpdateRequestDto requestDto);
}
