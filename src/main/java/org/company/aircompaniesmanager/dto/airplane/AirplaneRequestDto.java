package org.company.aircompaniesmanager.dto.airplane;

import java.time.LocalDate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import lombok.Data;

@Data
public class AirplaneRequestDto {
    @NotBlank
    private String factorySerialNumber;

    @Positive
    private Long airCompanyId;

    @Positive
    @NotNull
    private int numberOfFlights;

    @Positive
    @NotNull
    private double flightDistance;

    @Positive
    @NotNull
    private double fuelCapacity;

    @NotBlank
    private String type;

    @NotNull
    private LocalDate creationDate;
}
