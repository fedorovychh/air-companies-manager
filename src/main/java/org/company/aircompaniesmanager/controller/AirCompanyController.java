package org.company.aircompaniesmanager.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.company.aircompaniesmanager.dto.air.company.AirCompanyRequestDto;
import org.company.aircompaniesmanager.dto.air.company.AirCompanyResponseDto;
import org.company.aircompaniesmanager.dto.air.company.AirCompanyUpdateRequestDto;
import org.company.aircompaniesmanager.service.air.company.AirCompanyService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/air-companies")
@Tag(
        name = "Air companies management",
        description = "Endpoints for managing air companies"
)
public class AirCompanyController {
    private final AirCompanyService airCompanyService;

    @GetMapping
    @Operation(summary = "Find all air companies",
            description = "Retrieves detailed information about all companies")
    private List<AirCompanyResponseDto> findAll() {
        return airCompanyService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find air company by id",
            description = "Retrieves detailed information about specified company")
    private AirCompanyResponseDto findById(@PathVariable Long id) {
        return airCompanyService.findById(id);
    }

    @PostMapping
    @Operation(summary = "Save air company",
            description = "Creates new company")
    private AirCompanyResponseDto save(@RequestBody @Valid AirCompanyRequestDto requestDto) {
        return airCompanyService.save(requestDto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update air company",
            description = "Updates information about company type")
    private AirCompanyResponseDto updateById(
            @PathVariable Long id,
            @RequestBody @Valid AirCompanyUpdateRequestDto requestDto
    ) {
        return airCompanyService.updateById(id, requestDto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete air company",
            description = "Removes air company")
    private String deleteById(@PathVariable Long id) {
        airCompanyService.deleteById(id);
        return String.format("Company with id: '%s' deleted successfully.", id);
    }
}
