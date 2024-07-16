package com.ligabetplay.country.application;

import com.ligabetplay.country.domain.entity.Country;
import com.ligabetplay.country.domain.service.CountryService;

public class SaveCountryUseCase {
    private final CountryService countryService;

    public SaveCountryUseCase(CountryService countryService) {
        this.countryService = countryService;
    }

    public void execute(Country country) {
        countryService.createCountry(country);
    }
}
