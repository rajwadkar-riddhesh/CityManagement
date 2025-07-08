package com.example.CityManagement.service;

import com.example.CityManagement.dto.countrydto.CountryCreateDTO;
import com.example.CityManagement.dto.countrydto.CountryDTO;
import com.example.CityManagement.dto.countrydto.CountrySearchDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface CountryService {

    Page<CountryDTO> getAllCountryDetails(Pageable pageable);

    void importFromExcel(MultipartFile file) throws IOException;

    CountryDTO insertCountryDetails(CountryCreateDTO countryCreateDTO);

    Object deleteCountryDetails(Long countryId);

    CountryDTO updateCountryDetails(Long countryId, CountryCreateDTO countryCreateDTO);

//    CountryDTO searchCountryDetails(CountrySearchDTO countrySearchDTO);
}
