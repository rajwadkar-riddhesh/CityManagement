package com.example.CityManagement.controller;

import com.example.CityManagement.dto.countrydto.CountryCreateDTO;
import com.example.CityManagement.dto.countrydto.CountryDTO;
import com.example.CityManagement.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/country")
public class CountryController {

    private CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping()
    public ResponseEntity<Page<CountryDTO>> getAllCountryDetails(Pageable pageable){
        return ResponseEntity.ok(countryService.getAllCountryDetails(pageable));
    }

    @PostMapping("/insert")
    public ResponseEntity<CountryDTO> insertCountryDetails(@RequestBody  CountryCreateDTO countryCreateDTO){
        return ResponseEntity.ok(countryService.insertCountryDetails(countryCreateDTO));
    }

//    @GetMapping("/search")
//    public ResponseEntity<CountryDTO> searchCountryDetails(@RequestBody CountrySearchDTO countrySearchDTO){
//        return ResponseEntity.ok(countryService.searchCountryDetails(countrySearchDTO));
//    }
    @PutMapping("{countryId}")
    public ResponseEntity<CountryDTO> updateCountryDetails(@PathVariable Long countryId, @RequestBody CountryCreateDTO countryCreateDTO){
        return ResponseEntity.ok(countryService.updateCountryDetails(countryId,countryCreateDTO));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteCountryDetails(Long countryId){
        return ResponseEntity.ok(countryService.deleteCountryDetails(countryId).toString());
    }

    @PostMapping(value = "/import", consumes = "multipart/form-data")
    public ResponseEntity<String> importFromExcel(@RequestParam("file") MultipartFile file) throws IOException {
        countryService.importFromExcel(file);
        return ResponseEntity.ok("Data imported successfully");
    }
}
