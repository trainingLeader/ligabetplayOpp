package com.ligabetplay;

import java.io.IOException;
import java.text.MessageFormat;
// import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.ligabetplay.staticvar.Autoincrement;
import com.ligabetplay.torneo.Team;

public class Main {
    public static void main(String[] args) {
        int valueNumber = 0;
        Hashtable<Integer, Team> teams = new Hashtable<>();
        Team team;
        Autoincrement.uniqueNumbers = new HashSet<>();

        String miMenu = "1. Add Team\n2. View teams\n3. List panel\n4. Add Player\n5. Quit";
        int opcion;
        String leftAlignFormat = "| %-4d | %-40s |%n";

        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, miMenu));
            switch (opcion) {
                case 1:
                    team = new Team();
                    valueNumber = GenerateUnique();
                    team.setId(valueNumber);
                    team.setNameTeam(JOptionPane.showInputDialog(null, "Ingrese el nombre del equipo"));
                    team.setCity(JOptionPane.showInputDialog(null, "Ingrese ciudad origen"));
                    teams.put(valueNumber, team);
                    break;
                case 2:
                    clearConsole();
                    System.out.format("+------+------------------------------------------+%n");
                    System.out.format("| ID   | Name                                     |%n");
                    System.out.format("+------+------------------------------------------+%n");
                    teams.values().forEach(keyValue -> {
                        System.out.format(leftAlignFormat, keyValue.getId(), keyValue.getNameTeam());
                    });
                    System.out.format("+------+------------------------------------------+%n");
                    try {
                        System.in.read();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    showTeamsTable(teams);
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Gracias por usar nuestro servicios", "Informacion",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Error en el dato ingresado", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    break;
            }

        } while (opcion != 5);
        // team.setId(valueNumber);
        // team.setNameTeam(JOptionPane.showInputDialog(null, "Ingrese el nombre del
        // equipo"));
        // team.setCity(JOptionPane.showInputDialog(null, "Ingrese ciudad origen"));

        // teams.put(valueNumber, team);

        // team = teams.get(getLastNumber());

        // System.out.println(teams.containsKey(getLastNumber()));

        // teams.keySet().forEach(keyValue -> {
        // System.out.println(MessageFormat.format("Llave valor : {0}",
        // keyValue.toString()));
        // });

    }

    public static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
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

    public static void showTeamsTable(Hashtable<Integer, Team> teams) {
        String[] columns = { "ID", "Name" };
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        teams.values().forEach(team -> {
            Object[] row = { team.getId(), team.getNameTeam() };
            model.addRow(row);
        });

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(scrollPane);

        JOptionPane.showMessageDialog(null, panel, "Teams List", JOptionPane.PLAIN_MESSAGE);
    }
}