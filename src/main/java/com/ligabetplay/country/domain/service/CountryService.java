package com.ligabetplay.country.domain.service;

import java.util.List;
import java.util.Optional;

import com.ligabetplay.country.domain.entity.Country;



public interface CountryService {
    void createCountry(Country country);
    void updateCountry(Country country);
    Country deleteCountry(int id);
    Optional<Country> findCountryById(int id);
    Optional<List<Country>> findAllCountry();
}
