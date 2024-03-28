package org.company.aircompaniesmanager.mapper;

import org.company.aircompaniesmanager.config.MapperConfig;
import org.company.aircompaniesmanager.dto.air.company.AirCompanyRequestDto;
import org.company.aircompaniesmanager.dto.air.company.AirCompanyResponseDto;
import org.company.aircompaniesmanager.model.AirCompany;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface AirCompanyMapper {
    AirCompanyResponseDto toDto(AirCompany airCompany);

    AirCompany toEntity(AirCompanyRequestDto requestDto);
}
