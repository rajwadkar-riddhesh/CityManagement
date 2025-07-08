package com.example.CityManagement.dto.countrydto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CountryCreateDTO {

    @NotBlank(message = "Country name cannot be blank")
    @Size(max = 100, message = "Country name cannot exceed 100 characters")
    private String countryName;

    private Integer countryCode;

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Integer getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(Integer countryCode) {
        this.countryCode = countryCode;
    }

}
