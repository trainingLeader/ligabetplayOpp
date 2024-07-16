package com.ligabetplay.person.infrastructure;

import java.util.Optional;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.ligabetplay.person.application.CreatePersonUseCase;
import com.ligabetplay.person.application.FindPersonCiudad;
import com.ligabetplay.person.application.FindPersonUseCase;
import com.ligabetplay.person.domain.entity.Person;
import com.ligabetplay.person.domain.entity.PersonaDto;

public class PersonUi {
    private CreatePersonUseCase createPersonUseCase;
    private FindPersonUseCase findPersonUseCase;
    private FindPersonCiudad findpersonCiudad;
    private String idUser;

    public PersonUi(CreatePersonUseCase createPersonUseCase, FindPersonUseCase findPersonUseCase,
            FindPersonCiudad fpc) {
        this.createPersonUseCase = createPersonUseCase;
        this.findPersonUseCase = findPersonUseCase;
        this.findpersonCiudad = fpc;
    }

    public void frmRegPerson() {
        // Crear el JFrame
        JFrame frame = new JFrame("Registro de Personas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        // Crear el JPanel con BoxLayout para alineación vertical
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8)); // Espacio alrededor

        // Añadir componentes al topPanel
        JLabel lblId = new JLabel("Id Persona");
        lblId.setFont(new Font("Arial", Font.PLAIN, 18));
        lblId.setPreferredSize(new Dimension(100, 20));
        topPanel.add(lblId);
        topPanel.add(Box.createRigidArea(new Dimension(0, 2))); // Espacio vertical

        JTextField txtId = new JTextField();
        txtId.setFont(new Font("Arial", Font.PLAIN, 18));
        txtId.setPreferredSize(new Dimension(250, 40));
        txtId.setMaximumSize(new Dimension(250, 40));
        topPanel.add(txtId);
        topPanel.add(Box.createRigidArea(new Dimension(0, 5))); // Espacio vertical

        // Añadir componentes al topPanel
        JLabel lblNombre = new JLabel("Nombre");
        lblNombre.setFont(new Font("Arial", Font.PLAIN, 18));
        lblNombre.setPreferredSize(new Dimension(100, 20));
        lblNombre.setMaximumSize(new Dimension(450, 40));
        topPanel.add(lblNombre);
        topPanel.add(Box.createRigidArea(new Dimension(0, 2))); // Espacio vertical

        JTextField txtNombre = new JTextField();
        txtNombre.setFont(new Font("Arial", Font.PLAIN, 18));
        txtNombre.setPreferredSize(new Dimension(450, 40));
        topPanel.add(txtNombre);
        topPanel.add(Box.createRigidArea(new Dimension(0, 5))); // Espacio vertical

        JLabel lblApellidos = new JLabel("Apellidos");
        lblApellidos.setFont(new Font("Arial", Font.PLAIN, 18));
        lblApellidos.setPreferredSize(new Dimension(100, 20));
        lblApellidos.setMaximumSize(new Dimension(450, 40));
        topPanel.add(lblApellidos);
        topPanel.add(Box.createRigidArea(new Dimension(0, 2))); // Espacio vertical

        JTextField txtApellidos = new JTextField();
        txtApellidos.setFont(new Font("Arial", Font.PLAIN, 18));
        txtApellidos.setPreferredSize(new Dimension(450, 40));
        // txtApellidos.setMaximumSize(new Dimension(450, 40));
        topPanel.add(txtApellidos);
        topPanel.add(Box.createRigidArea(new Dimension(0, 5))); // Espacio vertical

        JLabel lblEmail = new JLabel("Correo electronico");
        lblEmail.setFont(new Font("Arial", Font.PLAIN, 18));
        lblEmail.setPreferredSize(new Dimension(100, 20));
        lblEmail.setMaximumSize(new Dimension(450, 40));
        topPanel.add(lblEmail);
        topPanel.add(Box.createRigidArea(new Dimension(0, 2))); // Espacio vertical

        JTextField txtEmail = new JTextField();
        txtEmail.setFont(new Font("Arial", Font.PLAIN, 18));
        txtEmail.setPreferredSize(new Dimension(450, 40));
        // txtEmail.setMaximumSize(new Dimension(450, 40));
        topPanel.add(txtEmail);
        topPanel.add(Box.createRigidArea(new Dimension(0, 5))); // Espacio vertical

        JLabel lblEdad = new JLabel("Edad de la persona");
        lblEdad.setFont(new Font("Arial", Font.PLAIN, 18));
        lblEdad.setPreferredSize(new Dimension(100, 20));
        lblEdad.setMaximumSize(new Dimension(450, 40));
        topPanel.add(lblEdad);
        topPanel.add(Box.createRigidArea(new Dimension(0, 2))); // Espacio vertical

        JTextField txtEdad = new JTextField();
        txtEdad.setFont(new Font("Arial", Font.PLAIN, 18));
        txtEdad.setPreferredSize(new Dimension(150, 40));
        txtEdad.setMaximumSize(new Dimension(150, 40));
        topPanel.add(txtEdad);
        topPanel.add(Box.createRigidArea(new Dimension(0, 5))); // Espacio vertical

        txtEdad.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE) {
                    JOptionPane.showMessageDialog(frame, "Campo solo numero", "Error", JOptionPane.ERROR_MESSAGE);
                    e.consume(); // Ignorar la tecla no numérica
                }
            }
        });
        txtEdad.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (txtEdad.getText().length() >= 2) {
                    JOptionPane.showMessageDialog(frame, "La edad no puede ser mayor a 99", "Error", JOptionPane.ERROR_MESSAGE);
                    e.consume(); // Ignorar la tecla si el límite se ha alcanzado
                }
            }
        });
        // Añadir el topPanel al JFrame en la posición NORTH
        frame.add(topPanel, BorderLayout.NORTH);
        // Crear el JPanel inferior con FlowLayout para los botones
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        // Crear los botones y añadirlos al bottomPanel
        JButton closeButton = new JButton("Cerrar");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Cerrar el JFrame
            }
        });
        bottomPanel.add(closeButton);

        // Añadir el bottomPanel al JFrame en la posición SOUTH
        frame.add(bottomPanel, BorderLayout.SOUTH);
        // Centrar el JFrame en la pantalla
        frame.setLocationRelativeTo(null);
        // Hacer visible el JFrame
        frame.setVisible(true);
        // txtId.setPreferredSize(new Dimension(300, 50));
        // JLabel lblNombre = new JLabel("Nombre:");
        // JTextField txtNombre = new JTextField();
        // JLabel lblApellidos = new JLabel("Apellidos:");
        // JTextField txtApellidos = new JTextField();
        // JLabel lblEdad = new JLabel("Edad:");
        // JTextField txtEdad = new JTextField();
        // panel.setPreferredSize(new Dimension(350, 120));

        // panel.add(lblId);
        // panel.add(txtId);
        // panel.add(lblNombre);
        // panel.add(txtNombre);
        // panel.add(lblApellidos);
        // panel.add(txtApellidos);
        // panel.add(lblEdad);
        // panel.add(txtEdad);
        // int option = JOptionPane.showConfirmDialog(
        // null,
        // panel,
        // "Registro de personas",
        // JOptionPane.OK_CANCEL_OPTION,
        // JOptionPane.QUESTION_MESSAGE
        // );

    }

    public void start() {
        Person person = new Person();
        person.setId(JOptionPane.showInputDialog(null, "Ingrese Id"));
        person.setNombre(JOptionPane.showInputDialog(null, "Ingrese Nombre de la Persona"));
        person.setApellido(JOptionPane.showInputDialog(null, "Ingrese Apellidos de la Persona"));
        person.setEmail(JOptionPane.showInputDialog(null, "Ingrese Email de la Persona"));
        person.setEdad(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese Edad de la Persona")));
        person.setIdciudad(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese Id Ciudad de la Persona")));
        createPersonUseCase.execute(person);
    }

    public Optional<Person> findPerson() {
        idUser = JOptionPane.showInputDialog(null, "Ingrese el ID del Usuario: ");
        Optional<Person> person = findPersonUseCase.execute(idUser);
        return person;
    }

    public Optional<PersonaDto> findPersonCiudad() {
        idUser = JOptionPane.showInputDialog(null, "Ingrese el ID del Usuario: ");
        Optional<PersonaDto> person = findpersonCiudad.execute(idUser);
        return person;
    }
}
