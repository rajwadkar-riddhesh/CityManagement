package com.example.CityManagement.mapper;

import com.example.CityManagement.dto.countrydto.CountryCreateDTO;
import com.example.CityManagement.dto.countrydto.CountryDTO;
import com.example.CityManagement.entity.CountryEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-08T12:59:16+0530",
    comments = "version: 1.6.3, compiler: javac, environment: Java 24.0.1 (Oracle Corporation)"
)
@Component
public class CountryMapperImpl implements CountryMapper {

    @Override
    public CountryEntity toEntity(CountryCreateDTO countryCreateDTO) {
        if ( countryCreateDTO == null ) {
            return null;
        }

        CountryEntity countryEntity = new CountryEntity();

        countryEntity.setCountryName( countryCreateDTO.getCountryName() );
        countryEntity.setCountryCode( countryCreateDTO.getCountryCode() );

        return countryEntity;
    }

    @Override
    public CountryDTO toDto(CountryEntity countryEntity) {
        if ( countryEntity == null ) {
            return null;
        }

        CountryDTO countryDTO = new CountryDTO();

        countryDTO.setCountryId( countryEntity.getCountryId() );
        countryDTO.setCountryName( countryEntity.getCountryName() );
        countryDTO.setCountryCode( countryEntity.getCountryCode() );
        countryDTO.setCreatedAt( countryEntity.getCreatedAt() );
        countryDTO.setUpdatedAt( countryEntity.getUpdatedAt() );
        countryDTO.setDeletedAt( countryEntity.getDeletedAt() );
        countryDTO.setStatus( countryEntity.getStatus() );

        return countryDTO;
    }

    @Override
    public void updateEntityFromDto(CountryCreateDTO countryCreateDTO, CountryEntity existingCountry) {
        if ( countryCreateDTO == null ) {
            return;
        }

        if ( countryCreateDTO.getCountryName() != null ) {
            existingCountry.setCountryName( countryCreateDTO.getCountryName() );
        }
        if ( countryCreateDTO.getCountryCode() != null ) {
            existingCountry.setCountryCode( countryCreateDTO.getCountryCode() );
        }
    }
}
