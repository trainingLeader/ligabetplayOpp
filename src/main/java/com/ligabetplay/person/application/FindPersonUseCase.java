package com.ligabetplay.person.application;

import java.util.Optional;

import com.ligabetplay.person.domain.entity.Person;
import com.ligabetplay.person.domain.service.PersonService;

public class FindPersonUseCase {
    private final PersonService personService;

    public FindPersonUseCase(PersonService personService) {
        this.personService = personService;
    }

    public Optional<Person> execute(String id) {
        return personService.findPersonById(id);
    }
}
