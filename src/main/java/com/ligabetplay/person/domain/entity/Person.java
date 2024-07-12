package com.ligabetplay.person.domain.entity;

public class Person {
    private String id;
    private String nombre;
    private String apellido;
    private int edad; 
    private String email;
    private int idciudad;
    public Person() {
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getIdciudad() {
        return idciudad;
    }
    public void setIdciudad(int idciudad) {
        this.idciudad = idciudad;
    }
}
