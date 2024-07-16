package com.ligabetplay;

import com.ligabetplay.country.application.SaveCountryUseCase;
import com.ligabetplay.country.domain.service.CountryService;
import com.ligabetplay.country.infrastructure.CountryRepository;
import com.ligabetplay.country.infrastructure.CountryUI;

// import java.util.Optional;

// import javax.swing.JOptionPane;

//import javax.swing.JOptionPane;

// import com.ligabetplay.person.application.CreatePersonUseCase;
// import com.ligabetplay.person.application.FindPersonCiudad;
// import com.ligabetplay.person.application.FindPersonUseCase;
// import com.ligabetplay.person.domain.entity.Person;
// import com.ligabetplay.person.domain.entity.PersonDto;
//import com.ligabetplay.person.domain.entity.PersonaDto;
// import com.ligabetplay.person.domain.service.PersonService;
// import com.ligabetplay.person.infrastructure.PersonRepository;
// import com.ligabetplay.person.infrastructure.PersonUi;

public class Main {
    public static void main(String[] args) {
        CountryService cs = new CountryRepository();
        SaveCountryUseCase scu = new SaveCountryUseCase(cs);
        CountryUI uiCountry = new CountryUI(scu);
        // PersonService personService = new PersonRepository();
        // CreatePersonUseCase createPersonUseCase = new CreatePersonUseCase(personService);
        // FindPersonUseCase findPersonById = new FindPersonUseCase(personService); 
        // FindPersonCiudad fpc = new FindPersonCiudad(personService); 
        // PersonUi consoleAdapter = new PersonUi(createPersonUseCase, findPersonById,fpc);
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
        uiCountry.frmRegPerson();
        
        // consoleAdapter.start();
    }
}