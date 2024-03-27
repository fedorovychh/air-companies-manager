package org.company.aircompaniesmanager.model;

import java.time.LocalDateTime;

public class Flight {
    private Long id;
    private Status status;
    private Long airCompanyId;
    private Long airplaneId;
    private String departureCountry;
    private String destinationCountry;
    private double distance;
    private double estimatedTime;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private LocalDateTime delayStartTime;
    private LocalDateTime creationDate;

    public enum Status {
        ACTIVE,
        COMPLETED,
        DELAYED,
        PENDING
    }
}
