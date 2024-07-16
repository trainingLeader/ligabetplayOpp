package com.ligabetplay.person.application;

import java.util.Optional;

import com.ligabetplay.person.domain.entity.PersonDto;
import com.ligabetplay.person.domain.service.PersonService;

public class FindPersonCiudad {
    private final PersonService personService;

    public FindPersonCiudad(PersonService personService) {
        this.personService = personService;
    }

    public Optional<PersonDto> execute(String id) {
        return personService.findPersonByIdCiudad(id);
    }
}
