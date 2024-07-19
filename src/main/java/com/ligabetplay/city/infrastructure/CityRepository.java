package com.ligabetplay.city.infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import com.ligabetplay.city.domain.entity.City;
import com.ligabetplay.city.domain.service.CityService;
import com.ligabetplay.person.domain.entity.PersonDto;

public class CityRepository implements CityService {
    private Connection connection;

    public CityRepository() {
        try {
            Properties props = new Properties();
            props.load(getClass().getClassLoader().getResourceAsStream("configdb.properties"));
            String url = props.getProperty("url");
            String user = props.getProperty("user");
            String password = props.getProperty("password");
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createCity(City person) {
        try {
            String query = "INSERT INTO ciudad (id,nombre,idregion) VALUES (?,?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, person.getId());
            ps.setString(2, person.getName());
            ps.setInt(3, person.getIdregion());
            ps.executeUpdate();            
        } catch (SQLException e) {
            // TODO: handle exception
        }
    }

    @Override
    public void updateCity(City persona) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateCity'");
    }

    @Override
    public City deleteCity(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteCity'");
    }

    @Override
    public Optional<City> findPersonById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findPersonById'");
    }

    @Override
    public List<City> findAllCities() {
        String query = "SELECT id, nombre, idregion " +
                        "FROM ciudad";
        List<City> lstCities = new ArrayList<>();

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        City city = new City(rs.getInt("id"), rs.getString("nombre"), rs.getInt("idregion"));
                        lstCities.add(city);
                    }
                    return lstCities;
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lstCities = new ArrayList<>();
    }

}
