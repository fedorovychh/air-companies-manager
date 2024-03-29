package org.company.aircompaniesmanager.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.company.aircompaniesmanager.dto.airplane.AirplaneRequestDto;
import org.company.aircompaniesmanager.dto.airplane.AirplaneResponseDto;
import org.company.aircompaniesmanager.dto.airplane.AirplaneUpdateRequestDto;
import org.company.aircompaniesmanager.service.airplane.AirplaneService;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/airplanes")
@Tag(
        name = "Airplanes management",
        description = "Endpoints for managing airplanes"
)
public class AirplaneController {
    private final AirplaneService airplaneService;

    @GetMapping
    @Operation(summary = "Find all airplanes",
            description = "Retrieves detailed information about all airplanes")
    public List<AirplaneResponseDto> findAll(Pageable pageable) {
        return airplaneService.findAll(pageable);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find airplane by id",
            description = "Retrieves detailed information about specified airplane")
    public AirplaneResponseDto findById(@PathVariable Long id) {
        return airplaneService.findById(id);
    }

    @PostMapping
    @Operation(summary = "Save new airplane",
            description = "Creates new airplane")
    public AirplaneResponseDto save(@RequestBody AirplaneRequestDto requestDto) {
        return airplaneService.save(requestDto);
    }

    @PatchMapping("/{airplaneId}/move")
    @Operation(summary = "Reassign to another company",
            description = "Updates airplane company")
    public AirplaneResponseDto updateCompany(
            @PathVariable Long airplaneId,
            @RequestBody AirplaneUpdateRequestDto requestDto
    ) {
        return airplaneService.updateCompany(airplaneId, requestDto);
    }
}
