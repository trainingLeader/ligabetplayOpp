package com.ligabetplay.person.infrastructure;

import java.util.Scanner;

import javax.swing.JOptionPane;

import com.ligabetplay.person.application.CreatePersonUseCase;
import com.ligabetplay.person.application.FindPersonUseCase;
import com.ligabetplay.person.domain.entity.Person;

public class PersonUi {
    private  CreatePersonUseCase createPersonUseCase;
    private FindPersonUseCase findPersonUseCase;
    private String idUser;
   
    public PersonUi(CreatePersonUseCase createPersonUseCase, FindPersonUseCase findPersonUseCase) {
        this.createPersonUseCase = createPersonUseCase;
        this.findPersonUseCase = findPersonUseCase;
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
    public Person findPerson() {
        idUser = JOptionPane.showInputDialog(null,"Ingrese el ID del Usuario: ");
        Person person = findPersonUseCase.execute(idUser);
        if (person != null) {
            JOptionPane.showMessageDialog(null, "Persona encontrada: \n" +
                    "ID: " + person.getId() + "\n" +
                    "Nombre: " + person.getNombre() + "\n" +
                    "Apellido: " + person.getApellido() + "\n" +
                    "Edad: " + person.getEdad() + "\n" +
                    "Email: " + person.getEmail() + "\n" +
                    "ID Ciudad: " + person.getIdciudad());
        } else {
            JOptionPane.showMessageDialog(null, "Persona no encontrada");
        }
        return person;
    }
}
