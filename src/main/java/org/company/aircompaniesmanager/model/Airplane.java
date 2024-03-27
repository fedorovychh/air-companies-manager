package org.company.aircompaniesmanager.model;

import java.time.LocalDate;

public class Airplane {
    private Long id;
    private String factorySerialNumber;
    private Long airCompanyId;
    private int numberOfFlights;
    private double flightDistance;
    private double fuelCapacity;
    private String type;
    private LocalDate creationDate;
}
