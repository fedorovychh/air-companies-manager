package org.company.aircompaniesmanager.dto.air.company;

import java.time.LocalDate;
import lombok.Data;

@Data
public class AirCompanyResponseDto {
    private Long id;
    private String name;
    private String companyType;
    private LocalDate foundationDate;
}
