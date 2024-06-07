package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VentanaResultados extends JFrame {
    private JPanel outputPanel;
    private JTable tablaResultados;
    private DefaultTableModel modelo;

    public VentanaResultados(Simulacion simulacion) {
        setTitle("Resultados de la Simulación");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);


        String[] columnas = {"Evento", "Reloj", "Préstamo RND", "Préstamo Tiempo", "Préstamo Próxima Llegada"
                //, "Devolución RND", "Devolución Tiempo", "Devolución Próxima Llegada", "Consulta RND", "Consulta Tiempo", "Consulta Próxima Llegada", "Acceso PC RND", "Acceso PC Tiempo", "Acceso PC Próxima Llegada", "Información RND", "Información Tiempo", "Información Próxima Llegada", "Extra RND", "Extra Tiempo", "Extra Próxima Llegada"
                };
        modelo = new DefaultTableModel(columnas, 0);
        tablaResultados = new JTable(modelo);
        JScrollPane scrollPane = new JScrollPane(tablaResultados);
        add(scrollPane, BorderLayout.CENTER);

        for (Object[] fila : simulacion.getResultados()) {
            modelo.addRow(fila);
        }
    }

}
