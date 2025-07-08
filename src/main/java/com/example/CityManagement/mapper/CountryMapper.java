package com.example.CityManagement.mapper;

import com.example.CityManagement.dto.countrydto.CountryCreateDTO;
import com.example.CityManagement.dto.countrydto.CountryDTO;
import com.example.CityManagement.entity.CountryEntity;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CountryMapper {

    CountryEntity toEntity(CountryCreateDTO countryCreateDTO);

    CountryDTO toDto(CountryEntity countryEntity);

    @BeanMapping(nullValuePropertyMappingStrategy = org.mapstruct.NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(CountryCreateDTO countryCreateDTO, @MappingTarget CountryEntity existingCountry);
}
