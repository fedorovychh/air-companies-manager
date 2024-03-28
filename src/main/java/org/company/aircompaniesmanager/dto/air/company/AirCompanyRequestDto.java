package org.company.aircompaniesmanager.dto.air.company;

import java.time.LocalDate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AirCompanyRequestDto {
    @NotBlank
    private String name;
    @NotBlank
    private String companyType;
    @NotNull
    private LocalDate foundationDate;
}
