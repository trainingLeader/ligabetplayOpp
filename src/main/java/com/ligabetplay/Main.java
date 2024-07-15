package com.ligabetplay;

import com.ligabetplay.person.application.CreatePersonUseCase;
import com.ligabetplay.person.application.FindPersonUseCase;
import com.ligabetplay.person.domain.entity.Person;
import com.ligabetplay.person.domain.service.PersonService;
import com.ligabetplay.person.infrastructure.PersonRepository;
import com.ligabetplay.person.infrastructure.PersonUi;

public class Main {
    public static void main(String[] args) {
        PersonService personService = new PersonRepository();
        CreatePersonUseCase createPersonUseCase = new CreatePersonUseCase(personService);
        FindPersonUseCase findPersonById = new FindPersonUseCase(personService); 
        PersonUi consoleAdapter = new PersonUi(createPersonUseCase, findPersonById);
        Person person = consoleAdapter.findPerson();
        System.out.println(person.getNombre());
        // consoleAdapter.start();
    }
}