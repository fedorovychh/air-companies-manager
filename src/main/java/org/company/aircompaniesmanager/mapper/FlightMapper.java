package org.company.aircompaniesmanager.mapper;

import org.company.aircompaniesmanager.config.MapperConfig;
import org.company.aircompaniesmanager.dto.flight.FlightRequestDto;
import org.company.aircompaniesmanager.dto.flight.FlightResponseDto;
import org.company.aircompaniesmanager.model.Flight;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfig.class)
public interface FlightMapper {
    @Mapping(target = "airplaneId", source = "airplane.id")
    @Mapping(target = "airCompanyId", source = "airCompany.id")
    FlightResponseDto toDto(Flight flight);

    Flight toEntity(FlightRequestDto requestDto);
}
