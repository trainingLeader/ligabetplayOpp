package com.ligabetplay.person.application;

import com.ligabetplay.person.domain.entity.Person;
import com.ligabetplay.person.domain.service.PersonService;

public class CreatePersonUseCase {
    private final PersonService personService;

    public CreatePersonUseCase(PersonService personService) {
        this.personService = personService;
    }

    public void execute(Person person) {
        personService.createPerson(person);
    }
}
