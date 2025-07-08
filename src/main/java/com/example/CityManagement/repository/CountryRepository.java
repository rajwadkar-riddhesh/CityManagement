package com.example.CityManagement.repository;

import com.example.CityManagement.entity.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<CountryEntity,Long> {

    CountryEntity findByCountryId(Long countryId);
}
