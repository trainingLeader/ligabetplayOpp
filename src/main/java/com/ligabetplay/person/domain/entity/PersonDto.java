package com.ligabetplay.person.domain.entity;

public class PersonDto {
    private String nombre;
    private String apellido;
    private String nombreCiudad;
    public PersonDto() {
    }
    
    public PersonDto(String nombre, String apellido, String nombreCiudad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nombreCiudad = nombreCiudad;
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
    public String getNombreCiudad() {
        return nombreCiudad;
    }
    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    
}
