package com.ligabetplay.person.domain.service;

import java.util.List;
import java.util.Optional;

import com.ligabetplay.person.domain.entity.Person;
import com.ligabetplay.person.domain.entity.PersonaDto;

public interface PersonService {
    void createPerson(Person person);
    void updatePerson(Person persona);
    Person deletePerson(String id);
    Optional<Person> findPersonById(String id);
    Optional<PersonaDto> findPersonByIdCiudad(String id);
    List<Person> findAllPerson();
}
