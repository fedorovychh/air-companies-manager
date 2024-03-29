package org.company.aircompaniesmanager.dto.airplane;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import lombok.Data;

@Data
public class AirplaneUpdateRequestDto {
    @NotNull
    @Positive
    private Long airCompanyId;
}
