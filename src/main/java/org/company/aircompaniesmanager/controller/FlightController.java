package org.company.aircompaniesmanager.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.company.aircompaniesmanager.dto.flight.FlightRequestDto;
import org.company.aircompaniesmanager.dto.flight.FlightResponseDto;
import org.company.aircompaniesmanager.dto.flight.FlightUpdateRequestDto;
import org.company.aircompaniesmanager.service.flight.FlightService;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/flights")
@Tag(
        name = "Flights management",
        description = "Endpoints for managing flights"
)
public class FlightController {
    private final FlightService flightService;

    @GetMapping
    @Operation(summary = "Find all flights",
            description = "Retrieves detailed information about all flights")
    List<FlightResponseDto> findAll(Pageable pageable) {
        return flightService.findAll(pageable);
    }

    @GetMapping("/{status}/company")
    @Operation(
            summary = "Find flight by status and company",
            description = "Retrieves detailed information "
                    + "about flights by specified company with specified status"
    )
    List<FlightResponseDto> findAllByCompanyNameAndStatus(
            @RequestParam String name,
            @PathVariable String status,
            Pageable pageable
    ) {
        return flightService.findAllByCompanyName(name, status, pageable);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find flight by id",
            description = "Retrieves detailed information about specified flight")
    FlightResponseDto findById(@PathVariable Long id) {
        return flightService.findById(id);
    }

    @PostMapping
    @Operation(summary = "Save new flight",
            description = "Creates new flight")
    FlightResponseDto save(@RequestBody FlightRequestDto requestDto) {
        return flightService.save(requestDto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update flight status",
            description = "Updates status in specified flight")
    FlightResponseDto updateStatus(
            @PathVariable Long id,
            @RequestBody FlightUpdateRequestDto requestDto
    ) {
        return flightService.updateStatus(id, requestDto);
    }
}
