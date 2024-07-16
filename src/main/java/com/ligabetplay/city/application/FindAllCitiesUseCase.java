package com.ligabetplay.city.application;

import java.util.List;
import java.util.Optional;

import com.ligabetplay.city.domain.entity.City;
import com.ligabetplay.city.domain.service.CityService;


public class FindAllCitiesUseCase {
    private final CityService cityservice;

    public FindAllCitiesUseCase(CityService cityservice) {
        this.cityservice = cityservice;
    }

    public Optional<List<City>> execute(String id) {
        return cityservice.findAllCities();
    }
}
