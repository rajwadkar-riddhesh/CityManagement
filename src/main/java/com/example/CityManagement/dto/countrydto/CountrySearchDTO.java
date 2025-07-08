package com.example.CityManagement.dto.countrydto;

import com.example.CityManagement.enums.CountryEnum;

public class CountrySearchDTO {

    private String countryName;

    private Integer countryCode;

    private CountryEnum status;

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

    public CountryEnum getStatus() {
        return status;
    }

    public void setStatus(CountryEnum status) {
        this.status = status;
    }
}
