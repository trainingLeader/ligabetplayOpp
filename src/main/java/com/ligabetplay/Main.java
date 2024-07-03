package com.ligabetplay;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JOptionPane;

import com.ligabetplay.staticvar.Autoincrement;
import com.ligabetplay.torneo.Team;

public class Main {
    public static void main(String[] args) {
        int valueNumber = 0;
        Hashtable<Integer, Team> teams = new Hashtable<>();
        Autoincrement.uniqueNumbers = new HashSet<>();
        Team team = new Team();

        valueNumber = GenerateUnique();

        team.setId(valueNumber);
        team.setNameTeam(JOptionPane.showInputDialog(null, "Ingrese el nombre del equipo"));
        team.setCity(JOptionPane.showInputDialog(null, "Ingrese ciudad origen"));

        teams.put(valueNumber, team);

        team = teams.get(getLastNumber());

        System.out.println(teams.containsKey(getLastNumber()));

        teams.keySet().forEach(keyValue -> {
            System.out.println(MessageFormat.format("Llave valor : {0}",
                    keyValue.toString()));
        });

    }

    public static int GenerateUnique() {
        int randomNumber = 0;
        randomNumber = ThreadLocalRandom.current().nextInt(Autoincrement.max);
        Autoincrement.uniqueNumbers.add(randomNumber);
        return randomNumber;
    }

    public static int getLastNumber() {
        List<Integer> numberList = new ArrayList<>(Autoincrement.uniqueNumbers);
        return numberList.get(numberList.size() - 1);
    }
}