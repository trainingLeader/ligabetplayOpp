package com.ligabetplay.torneo;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private int id;
    private String nameTeam;
    private String city;
    private List<Player> player;
    private List<Coach> coach;
    private List<Doctor> doctor;

    public Team() {
        this.player = new ArrayList<>();
        this.coach = new ArrayList<>();
        this.doctor = new ArrayList<>();
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNameTeam() {
        return nameTeam;
    }
    public void setNameTeam(String nameTeam) {
        this.nameTeam = nameTeam;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public List<Player> getPlayer() {
        return player;
    }
    public void setPlayer(Player player) {
        this.player.add(player);
    }
    public List<Coach> getCoach() {
        return coach;
    }
    public void setCoach(Coach coach) {
        this.coach.add(coach);
    }
    public List<Doctor> getDoctor() {
        return doctor;
    }
    public void setDoctor(Doctor doctor) {
        this.doctor.add(doctor);
    }

    



}
