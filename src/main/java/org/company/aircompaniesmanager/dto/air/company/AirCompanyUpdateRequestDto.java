package org.company.aircompaniesmanager.dto.air.company;

import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AirCompanyUpdateRequestDto {
    @NotBlank
    private String companyType;
}
