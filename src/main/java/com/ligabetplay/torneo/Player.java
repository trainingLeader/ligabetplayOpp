package com.ligabetplay.torneo;

public class Player extends Person {
    private int number;
    private String fieldPosition;

    public Player(){
        super();
    }

    public Player(int number, String fieldPosition) {
        this.number = number;
        this.fieldPosition = fieldPosition;
    }

    public Player(int id, String name, String lastName, int age, int number, String fieldPosition) {
        super(id, name, lastName, age);
        this.number = number;
        this.fieldPosition = fieldPosition;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getFieldPosition() {
        return fieldPosition;
    }

    public void setFieldPosition(String fieldPosition) {
        this.fieldPosition = fieldPosition;
    }


    

}
