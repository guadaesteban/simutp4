package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaDatos extends JFrame {
    private JPanel mainPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField cantSimuField;
    private JTextField desdeField;
    private JTextField hastaField;
    private JButton simularButton;


    public VentanaDatos() {
        setTitle("Ventana Datos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,600);
        setLocationRelativeTo(null);

        cantSimuField.setText("10");
        desdeField.setText("1");
        hastaField.setText("10");

        simularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int cantidadSimulaciones = Integer.parseInt(cantSimuField.getText());
                int desde = Integer.parseInt(desdeField.getText());
                int hasta = Integer.parseInt(hastaField.getText());

                Simulacion simulacion = new Simulacion(cantidadSimulaciones, desde, hasta);
                // simulacion.simular();
                // VentanaResultados ventanaResultados = new VentanaResultados(simulacion.getResultados());
                // ventanaResultados.setVisible(true);
            }
        });

        setContentPane(mainPanel);

    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                VentanaDatos frame = new VentanaDatos();
                frame.setVisible(true);
            }
        });
    }
}

