package com.ligabetplay;

import com.ligabetplay.person.application.CreatePersonUseCase;
import com.ligabetplay.person.application.FindPersonCiudad;
import com.ligabetplay.person.application.FindPersonUseCase;
import com.ligabetplay.person.domain.service.PersonService;
import com.ligabetplay.person.infrastructure.PersonRepository;
import com.ligabetplay.person.infrastructure.PersonUi;

public class Main {
    public static void main(String[] args) {
        // CountryService cs = new CountryRepository();
        // SaveCountryUseCase scu = new SaveCountryUseCase(cs);
        // CountryUI uiCountry = new CountryUI(scu);
        PersonService personService = new PersonRepository();
        CreatePersonUseCase createPersonUseCase = new CreatePersonUseCase(personService);
        FindPersonUseCase findPersonById = new FindPersonUseCase(personService); 
        FindPersonCiudad fpc = new FindPersonCiudad(personService); 
        PersonUi consoleAdapter = new PersonUi(createPersonUseCase, findPersonById,fpc);
        // Optional<PersonDto> miPersona = consoleAdapter.findPersonCiudad();

        // miPersona.ifPresentOrElse(
        //             personFind -> { 
        //                 JOptionPane.showMessageDialog(null, "Persona encontrada: \n" +
        //                 "Nombre: " + personFind.getNombre() + "\n" +
        //                 "Apellido: " + personFind.getApellido() + "\n" +
        //                 "Ciudad: " + personFind.getNombreCiudad());
        //             },
        //             ()-> {
                       
        //             }
                
        //         );
        consoleAdapter.frmRegPerson();
        
        // consoleAdapter.start();
    }
}