package org.company.aircompaniesmanager.dto.airplane;

import java.time.LocalDate;
import lombok.Data;

@Data
public class AirplaneResponseDto {
    private Long id;
    private String factorySerialNumber;
    private Long airCompanyId;
    private int numberOfFlights;
    private double flightDistance;
    private double fuelCapacity;
    private String type;
    private LocalDate creationDate;
}
