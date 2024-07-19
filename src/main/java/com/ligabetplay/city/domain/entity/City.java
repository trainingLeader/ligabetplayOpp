package com.ligabetplay.city.domain.entity;

public class City {
    private int id;
    private String name;
    private int idregion;
    public City() {
    }
    
    public City(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public City(int id, String name, int idregion) {
        this.id = id;
        this.name = name;
        this.idregion = idregion;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getIdregion() {
        return idregion;
    }
    public void setIdregion(int idregion) {
        this.idregion = idregion;
    }

    
}
