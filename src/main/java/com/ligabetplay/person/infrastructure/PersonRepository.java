package com.ligabetplay.person.infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import com.ligabetplay.person.domain.entity.Person;
import com.ligabetplay.person.domain.entity.PersonaDto;
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
            ps.setString(2, person.getNombre());
            ps.setString(3, person.getApellido());
            ps.setInt(4, person.getEdad());
            ps.setString(5, person.getEmail());
            ps.setInt(6, person.getIdciudad());
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
    public Optional<Person> findPersonById(String id) {
        String query = "SELECT id, nombre, apellido, email, edad, idciudad FROM persona WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        Person person = new Person(rs.getString("id"), rs.getString("nombre"), rs.getString("apellido"), rs.getInt("edad"), rs.getString("email"), rs.getInt("idciudad"));
                        return Optional.of(person);
                    }
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Person> findAllPerson() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllPerson'");
    }

    @Override
    public Optional<PersonaDto> findPersonByIdCiudad(String id) {
        String query = "SELECT p.id, p.nombre, p.apellido, p.email, p.edad, p.idciudad,c.nombre " +
                        "FROM persona as p " + 
                        "join ciudad as c on p.idciudad = c.id WHERE p.id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        PersonaDto person = new PersonaDto(rs.getString("p.id"), rs.getString("p.nombre"), rs.getString("p.apellido"), rs.getInt("p.edad"), rs.getString("p.email"), rs.getString("c.nombre"));
                        return Optional.of(person);
                    }
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

}
