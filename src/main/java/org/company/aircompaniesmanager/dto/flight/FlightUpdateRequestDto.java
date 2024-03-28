package org.company.aircompaniesmanager.dto.flight;

import javax.validation.constraints.NotBlank;
import lombok.Data;
import org.company.aircompaniesmanager.model.Flight.Status;

@Data
public class FlightUpdateRequestDto {
    @NotBlank
    private Status status;
}
