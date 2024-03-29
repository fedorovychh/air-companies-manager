package org.company.aircompaniesmanager.dto.flight;

import java.time.LocalDateTime;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import lombok.Data;

@Data
public class FlightRequestDto {
    @NotNull
    @Positive
    private Long airCompanyId;

    @NotNull
    @Positive
    private Long airplaneId;

    @NotBlank
    private String departureCountry;

    @NotBlank
    private String destinationCountry;

    @NotNull
    @Positive
    private double distance;

    @NotNull
    @Positive
    // Estimated time in hours
    private double estimatedTime;

    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private LocalDateTime delayStartTime;
    private LocalDateTime creationDate;
}
