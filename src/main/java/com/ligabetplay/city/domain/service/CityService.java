package com.ligabetplay.city.domain.service;

import java.util.List;
import java.util.Optional;

import com.ligabetplay.city.domain.entity.City;

public interface CityService {
    void createCity(City person);
    void updateCity(City persona);
    City deleteCity(int id);
    Optional<City> findPersonById(int id);
    Optional<List<City>> findAllCities();
}
