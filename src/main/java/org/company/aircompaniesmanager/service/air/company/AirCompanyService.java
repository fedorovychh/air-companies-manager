package org.company.aircompaniesmanager.service.air.company;

import java.util.List;
import org.company.aircompaniesmanager.dto.air.company.AirCompanyRequestDto;
import org.company.aircompaniesmanager.dto.air.company.AirCompanyResponseDto;
import org.company.aircompaniesmanager.dto.air.company.AirCompanyUpdateRequestDto;

public interface AirCompanyService {
    List<AirCompanyResponseDto> findAll();

    AirCompanyResponseDto findById(Long id);

    AirCompanyResponseDto save(AirCompanyRequestDto requestDto);

    AirCompanyResponseDto updateById(Long id, AirCompanyUpdateRequestDto requestDto);

    void deleteById(Long id);
}
