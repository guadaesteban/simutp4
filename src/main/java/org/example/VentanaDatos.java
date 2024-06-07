package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaDatos extends JFrame {
    private JPanel mainPanel;
    private JTextField cantSimuField;
    private JTextField desdeField;
    private JTextField hastaField;
    private JButton simularButton;
    private JTextField prestamoTLTextField;
    private JTextField devolucionTLTextField;
    private JTextField consultaTLTextField;
    private JTextField accesoPcTLTextField;
    private JTextField infoTLTextField;
    private JTextField extraTLTextField;
    private JTextField prestamoTSTextField;
    private JTextField devolucionTSTextField;
    private JTextField consultaTSTextField;
    private JTextField accesoPcTSTextField;
    private JTextField infoTSTextField;
    private JTextField extraTSTextField;

    public VentanaDatos() {
        setTitle("Ventana Datos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,600);
        setLocationRelativeTo(null);

        simularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    int cantidadSimulaciones = Integer.parseInt(cantSimuField.getText());
                    int desde = Integer.parseInt(desdeField.getText());
                    int hasta = Integer.parseInt(hastaField.getText());
                    double prestamoTL = Double.parseDouble(prestamoTLTextField.getText());
                    double devolucionTL = Double.parseDouble(devolucionTLTextField.getText());
                    double consultaTL = Double.parseDouble(consultaTLTextField.getText());
                    double accesoPcTL = Double.parseDouble(accesoPcTLTextField.getText());
                    double infoTL = Double.parseDouble(infoTLTextField.getText());
                    double extraTL = Double.parseDouble(extraTLTextField.getText());
                    double prestamoTS = Double.parseDouble(prestamoTSTextField.getText());
                    double devolucionTS = Double.parseDouble(devolucionTSTextField.getText());
                    double consultaTS = Double.parseDouble(consultaTSTextField.getText());
                    double accesoPcTS = Double.parseDouble(accesoPcTSTextField.getText());
                    double infoTS = Double.parseDouble(infoTSTextField.getText());
                    double extraTS = Double.parseDouble(extraTSTextField.getText());

                    /*System.out.printf("Prestamo TL: %.2f%n", prestamoTL);
                    System.out.printf("Consulta TL: %.2f%n", consultaTL);
                    System.out.printf("Acceso PC TL: %.2f%n", accesoPcTL);
                    System.out.printf("Info TL: %.2f%n", infoTL);
                    System.out.printf("Extra TL: %.2f%n", extraTL);
                    System.out.printf("Prestamo TS: %.2f%n", prestamoTS);
                    System.out.printf("Devolucion TS: %.2f%n", devolucionTS);
                    System.out.printf("Consulta TS: %.2f%n", consultaTS);
                    System.out.printf("Acceso PC TS: %.2f%n", accesoPcTS);
                    System.out.printf("Info TS: %.2f%n", infoTS);
                    System.out.printf("Extra TS: %.2f%n", extraTS);*/

                    Simulacion simulacion = new Simulacion(cantidadSimulaciones, desde, hasta,
                            prestamoTL, devolucionTL, consultaTL, accesoPcTL, infoTL, extraTL,
                            prestamoTS, devolucionTS, consultaTS, accesoPcTS, infoTS, extraTS);
                    simulacion.simular();

                    VentanaResultados ventanaResultados = new VentanaResultados(simulacion);
                    ventanaResultados.setVisible(true);

                } catch (NumberFormatException exc) {
                    JOptionPane.showMessageDialog(VentanaDatos.this, "Por favor, ingrese valores numéricos válidos.", "Error", JOptionPane.ERROR_MESSAGE);
                    exc.printStackTrace();
                }
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

