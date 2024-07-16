package com.ligabetplay;

import java.util.Optional;

//import javax.swing.JOptionPane;

import com.ligabetplay.person.application.CreatePersonUseCase;
import com.ligabetplay.person.application.FindPersonCiudad;
import com.ligabetplay.person.application.FindPersonUseCase;
//import com.ligabetplay.person.domain.entity.PersonaDto;
import com.ligabetplay.person.domain.service.PersonService;
import com.ligabetplay.person.infrastructure.PersonRepository;
import com.ligabetplay.person.infrastructure.PersonUi;

public class Main {
    public static void main(String[] args) {
        PersonService personService = new PersonRepository();
        CreatePersonUseCase createPersonUseCase = new CreatePersonUseCase(personService);
        FindPersonUseCase findPersonById = new FindPersonUseCase(personService); 
        FindPersonCiudad fpc = new FindPersonCiudad(personService); 
        PersonUi consoleAdapter = new PersonUi(createPersonUseCase, findPersonById,fpc);
        //Optional<PersonaDto> miPersona = consoleAdapter.findPersonCiudad();

        // miPersona.ifPresentOrElse(
        //             personFind -> { 
        //                 JOptionPane.showMessageDialog(null, "Persona encontrada: \n" +
        //                 "ID: " + personFind.getId() + "\n" +
        //                 "Nombre: " + personFind.getNombre() + "\n" +
        //                 "Apellido: " + personFind.getApellido() + "\n" +
        //                 "Edad: " + personFind.getEdad() + "\n" +
        //                 "Email: " + personFind.getEmail() + "\n" +
        //                 "Ciudad: " + personFind.getNombreCiudad());
        //             },
        //             ()-> {
                       
        //             }
                
        //         );
        consoleAdapter.frmRegPerson();
        
        // consoleAdapter.start();
    }
}