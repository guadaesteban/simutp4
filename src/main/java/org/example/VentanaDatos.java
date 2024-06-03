package org.example;

import javax.swing.*;

public class VentanaDatos {
    private JPanel mainPanel;
    private JTextField textField1;
    private JButton simularButton;
    private JTextField textField2;
    private JTextField textField3;

    public static void main(String[] args) {
        JFrame frame = new JFrame("VentanaDatos");
        frame.setContentPane(new VentanaDatos().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
