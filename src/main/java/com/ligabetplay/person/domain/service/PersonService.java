package com.ligabetplay.person.domain.service;

import java.util.List;

import com.ligabetplay.person.domain.entity.Person;

public interface PersonService {
    void createPerson(Person person);
    void updatePerson(Person persona);
    Person deletePerson(String id);
    Person findPersonById(String id);
    List<Person> findAllPerson();
}
