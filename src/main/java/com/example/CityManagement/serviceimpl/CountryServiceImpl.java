package com.example.CityManagement.serviceimpl;

import com.example.CityManagement.dto.countrydto.CountryCreateDTO;
import com.example.CityManagement.dto.countrydto.CountryDTO;
import com.example.CityManagement.dto.countrydto.CountrySearchDTO;
import com.example.CityManagement.entity.CountryEntity;
import com.example.CityManagement.mapper.CountryMapper;
import com.example.CityManagement.repository.CountryRepository;
import com.example.CityManagement.service.CountryService;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    private CountryRepository countryRepository;
    private CountryMapper countryMapper;

    @Autowired
    public CountryServiceImpl(CountryRepository countryRepository, CountryMapper countryMapper) {
        this.countryRepository = countryRepository;
        this.countryMapper = countryMapper;
    }

    public Page<CountryDTO> getAllCountryDetails(Pageable pageable) {
        return countryRepository.findAll(pageable).map(countryMapper::toDto);
    }

    public CountryDTO insertCountryDetails(CountryCreateDTO countryCreateDTO) {
        CountryEntity countryEntity = countryMapper.toEntity(countryCreateDTO);
        return countryMapper.toDto(countryRepository.save(countryEntity));
    }

    @Override
    public CountryDTO updateCountryDetails(Long countryId, CountryCreateDTO countryCreateDTO) {
        CountryEntity existingCountry = countryRepository.findByCountryId(countryId);
        if (existingCountry == null) {
            throw new IllegalArgumentException("Country with ID " + countryId + " does not exist");
        }

        countryMapper.updateEntityFromDto(countryCreateDTO, existingCountry);
        return countryMapper.toDto(countryRepository.save(existingCountry));
    }

    public String deleteCountryDetails(Long countryId) {
        CountryEntity countryEntity = countryRepository.findByCountryId(countryId);
        countryRepository.delete(countryEntity);
        return "Deleted Successfully";
    }

//    @Override
//    public CountryDTO searchCountryDetails(CountrySearchDTO countrySearchDTO) {
//        CountryEntity countryEntity = countryMapper.toEntity(countrySearchDTO)
//    }

    public void importFromExcel(MultipartFile file) throws IOException {

        if (file.isEmpty()) {throw new IllegalArgumentException("Excel file is empty");}

        String fileName = file.getOriginalFilename();
        if (fileName == null || !fileName.toLowerCase().endsWith(".xlsx")) {throw  new IllegalArgumentException("Only .xlsx file are supported");}

        try(Workbook workbook = new XSSFWorkbook(file.getInputStream())) {
            Sheet sheet = workbook.getSheetAt(0);

            List<CountryEntity> countries = new ArrayList<>();

            for (Row row : sheet){
                if (row.getRowNum() == 0 || row.getCell(0) == null) continue;

                String countryId = new DataFormatter().formatCellValue(row.getCell(0)).trim();
                if(countryId.isBlank()) continue;

                String countryName = new DataFormatter().formatCellValue(row.getCell(1)).trim();
                if(countryName.isBlank()) continue;

                String countryCode = new DataFormatter().formatCellValue(row.getCell(4  )).trim();
                if(countryCode.isBlank()) continue;

                Long id;
                try {
                    id = Long.valueOf(countryId);
                }catch (NumberFormatException e){
                    continue;
                }

                Integer code;
                try {
                    code = Integer.valueOf(countryCode);
                }catch (NumberFormatException e){
                    continue;
                }

                CountryEntity entity = countryRepository.findById(id)
                                .orElse(new CountryEntity());

                entity.setCountryName(countryName);
                entity.setCountryCode(Integer.valueOf(countryCode));

                countries.add(entity);
            }
            countryRepository.saveAll(countries);
        }
    }
}
