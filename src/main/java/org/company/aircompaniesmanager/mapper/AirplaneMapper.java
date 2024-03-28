package org.company.aircompaniesmanager.mapper;

import org.company.aircompaniesmanager.config.MapperConfig;
import org.company.aircompaniesmanager.dto.airplane.AirplaneRequestDto;
import org.company.aircompaniesmanager.dto.airplane.AirplaneResponseDto;
import org.company.aircompaniesmanager.model.Airplane;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfig.class)
public interface AirplaneMapper {
    @Mapping(target = "airCompanyId", source = "airCompany.id")
    AirplaneResponseDto toDto(Airplane airplane);

    Airplane toEntity(AirplaneRequestDto requestDto);
}
