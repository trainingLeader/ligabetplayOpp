package com.ligabetplay.person.infrastructure;

import java.util.Optional;

import javax.swing.JOptionPane;
import com.ligabetplay.person.application.CreatePersonUseCase;
import com.ligabetplay.person.application.FindPersonCiudad;
import com.ligabetplay.person.application.FindPersonUseCase;
import com.ligabetplay.person.domain.entity.Person;
import com.ligabetplay.person.domain.entity.PersonaDto;

public class PersonUi {
    private  CreatePersonUseCase createPersonUseCase;
    private FindPersonUseCase findPersonUseCase;
    private FindPersonCiudad findpersonCiudad;
    private String idUser;
   
    public PersonUi(CreatePersonUseCase createPersonUseCase, FindPersonUseCase findPersonUseCase,FindPersonCiudad fpc) {
        this.createPersonUseCase = createPersonUseCase;
        this.findPersonUseCase = findPersonUseCase;
        this.findpersonCiudad = fpc;
    }

    public void start() {
        Person person  = new Person(); 
        person.setId(JOptionPane.showInputDialog(null,"Ingrese Id"));
        person.setNombre(JOptionPane.showInputDialog(null,"Ingrese Nombre de la Persona"));        
        person.setApellido(JOptionPane.showInputDialog(null,"Ingrese Apellidos de la Persona"));        
        person.setEmail(JOptionPane.showInputDialog(null,"Ingrese Email de la Persona"));        
        person.setEdad(Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese Edad de la Persona")));        
        person.setIdciudad(Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese Id Ciudad de la Persona")));        
        createPersonUseCase.execute(person);
    }
    public Optional<Person> findPerson() {
        idUser = JOptionPane.showInputDialog(null,"Ingrese el ID del Usuario: ");
        Optional<Person> person = findPersonUseCase.execute(idUser);
        return person;
    }
    public Optional<PersonaDto> findPersonCiudad() {
        idUser = JOptionPane.showInputDialog(null,"Ingrese el ID del Usuario: ");
        Optional<PersonaDto> person = findpersonCiudad.execute(idUser);
        return person;
    }
}
