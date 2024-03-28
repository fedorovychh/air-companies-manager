package org.company.aircompaniesmanager.service.air.company;

import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.company.aircompaniesmanager.dto.air.company.AirCompanyRequestDto;
import org.company.aircompaniesmanager.dto.air.company.AirCompanyResponseDto;
import org.company.aircompaniesmanager.dto.air.company.AirCompanyUpdateRequestDto;
import org.company.aircompaniesmanager.mapper.AirCompanyMapper;
import org.company.aircompaniesmanager.model.AirCompany;
import org.company.aircompaniesmanager.repository.AirCompanyRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AirCompanyServiceImpl implements AirCompanyService {
    private final AirCompanyMapper airCompanyMapper;
    private final AirCompanyRepository airCompanyRepository;

    @Override
    public List<AirCompanyResponseDto> findAll(Pageable pageable) {
        return airCompanyRepository.findAll(pageable).stream()
                .map(airCompanyMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public AirCompanyResponseDto findById(Long id) {
        AirCompany airCompany = airCompanyRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Can't find air company by id: " + id)
        );
        return airCompanyMapper.toDto(airCompany);
    }

    @Override
    public AirCompanyResponseDto save(AirCompanyRequestDto requestDto) {
        AirCompany airCompany = airCompanyRepository.save(airCompanyMapper.toEntity(requestDto));
        return airCompanyMapper.toDto(airCompany);
    }

    @Override
    @Transactional
    public AirCompanyResponseDto updateById(
            Long id,
            AirCompanyUpdateRequestDto requestDto
    ) {
        AirCompany airCompany = airCompanyRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Can't find air company by id: " + id)
        );
        airCompany.setCompanyType(requestDto.getCompanyType());
        return airCompanyMapper.toDto(airCompanyRepository.save(airCompany));
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        airCompanyRepository.deleteById(id);
    }
}
