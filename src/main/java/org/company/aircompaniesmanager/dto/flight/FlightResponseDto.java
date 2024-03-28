package org.company.aircompaniesmanager.dto.flight;

import java.time.LocalDateTime;
import lombok.Data;
import org.company.aircompaniesmanager.model.Flight.Status;

@Data
public class FlightResponseDto {
    private Long id;
    private Status status;
    private Long airplaneId;
    private String departureCountry;
    private String destinationCountry;
    private double distance;
    private double estimatedTime;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private LocalDateTime delayStartTime;
    private LocalDateTime creationDate;
}
