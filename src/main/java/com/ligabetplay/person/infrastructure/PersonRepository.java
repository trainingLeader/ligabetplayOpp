package com.ligabetplay.person.infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import com.ligabetplay.person.domain.entity.Person;
import com.ligabetplay.person.domain.service.PersonService;

public class PersonRepository implements PersonService {
    private Connection connection;

    public PersonRepository() {
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
    public void createPerson(Person person){
        try {
            String query = "INSERT INTO persona (id,nombre,apellido,edad,email,idciudad) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, person.getId());
            ps.executeUpdate();
            
        } catch (SQLException e) {
            // TODO: handle exception
        }
    }

    @Override
    public void updatePerson(Person persona) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updatePerson'");
    }

    @Override
    public Person deletePerson(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletePerson'");
    }

    @Override
    public Person findPersonById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findPersonById'");
    }

    @Override
    public List<Person> findAllPerson() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllPerson'");
    }

}
