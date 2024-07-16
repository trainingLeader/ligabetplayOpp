package com.ligabetplay.country.infrastructure;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import com.ligabetplay.country.application.SaveCountryUseCase;
import com.ligabetplay.country.domain.entity.Country;


public class CountryUI {
    private SaveCountryUseCase saveCountryUseCase;

    public CountryUI(SaveCountryUseCase saveCountryUseCase) {
        this.saveCountryUseCase = saveCountryUseCase;
    }
    
    public void frmRegPerson() {
        // Crear el JFrame
        JFrame frame = new JFrame("Registro de Paises");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        // Crear el JPanel con BoxLayout para alineación vertical
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8)); // Espacio alrededor

        // Añadir componentes al topPanel
        // Añadir componentes al topPanel
        JLabel lblNombre = new JLabel("Nombre del pais");
        lblNombre.setFont(new Font("Arial", Font.PLAIN, 18));
        lblNombre.setPreferredSize(new Dimension(100, 20));
        lblNombre.setMaximumSize(new Dimension(450, 40));
        topPanel.add(lblNombre);
        topPanel.add(Box.createRigidArea(new Dimension(0, 2))); // Espacio vertical

        JTextField txtNombre = new JTextField();
        txtNombre.setFont(new Font("Gadugi", Font.PLAIN, 18));
        txtNombre.setPreferredSize(new Dimension(450, 40));
        topPanel.add(txtNombre);
        topPanel.add(Box.createRigidArea(new Dimension(0, 5))); // Espacio vertical

    
        // Añadir el topPanel al JFrame en la posición NORTH
        frame.add(topPanel, BorderLayout.NORTH);
        // Crear el JPanel inferior con FlowLayout para los botones
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        // Crear los botones y añadirlos al bottomPanel
        JButton saveButton = new JButton("Guardar datos");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Country country = new Country();
                country.setName(txtNombre.getText());
                saveCountryUseCase.execute(country);
            }
        });

        JButton closeButton = new JButton("Cerrar");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Cerrar el JFrame
            }
        });

        bottomPanel.add(saveButton);
        bottomPanel.add(closeButton);


        // Añadir el bottomPanel al JFrame en la posición SOUTH
        frame.add(bottomPanel, BorderLayout.SOUTH);
        // Centrar el JFrame en la pantalla
        frame.setLocationRelativeTo(null);
        // Hacer visible el JFrame
        frame.setVisible(true);
    }
}
