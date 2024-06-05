package org.example;

import javax.swing.*;

public class VentanaResultados {
    public static void main(String[] args) {
        JFrame frame = new JFrame("VentanaResultados");
        frame.setContentPane(new VentanaResultados().outputPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private JPanel outputPanel;
    private JTable table1;
}
