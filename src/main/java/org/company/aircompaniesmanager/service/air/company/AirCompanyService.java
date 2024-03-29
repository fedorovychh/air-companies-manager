package org.company.aircompaniesmanager.service.air.company;

import java.util.List;
import org.company.aircompaniesmanager.dto.air.company.AirCompanyRequestDto;
import org.company.aircompaniesmanager.dto.air.company.AirCompanyResponseDto;
import org.company.aircompaniesmanager.dto.air.company.AirCompanyUpdateRequestDto;
import org.springframework.data.domain.Pageable;

public interface AirCompanyService {
    List<AirCompanyResponseDto> findAll(Pageable pageable);

    AirCompanyResponseDto findById(Long id);

    AirCompanyResponseDto findByName(String name);

    AirCompanyResponseDto save(AirCompanyRequestDto requestDto);

    AirCompanyResponseDto updateById(Long id, AirCompanyUpdateRequestDto requestDto);

    void deleteById(Long id);
}
