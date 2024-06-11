package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class VentanaResultados extends JFrame {
    private JPanel outputPanel;
    private JTable tablaResultados;
    private JScrollPane scrollPane;
    private DefaultTableModel modelo;

    public VentanaResultados(Simulacion simulacion) {
        initComponents();

        setTitle("Resultados de la Simulación");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        List<String> columnasList = new ArrayList<>();

        columnasList.add("Evento");
        columnasList.add("Reloj");

        String[] servicios = {"Préstamo", "Devolución", "Consulta", "Acceso PC", "Informa. gral", "Extra"};
        String[] subColumnas = {"RND", "Tiempo", "Próxima Llegada"};

        for (String servicio : servicios) {
            for (String subColumna : subColumnas) {
                columnasList.add(servicio + " " + subColumna);
            }
        }

        String[] tiposServidores = {"PL", "DL"};
        int[] numServidores = {3, 2};

        for (int i = 0; i < tiposServidores.length; i++) {
            for (int j = 1; j <= numServidores[i]; j++) {
                columnasList.add(tiposServidores[i] + " S" + j + " estado");
                columnasList.add(tiposServidores[i] + " S" + j + " rnd Duracion");
                columnasList.add(tiposServidores[i] + " S" + j + " duracion");
                columnasList.add(tiposServidores[i] + " S" + j + " fin de atencion");
            }
            columnasList.add(tiposServidores[i] + " cola");
            columnasList.add(tiposServidores[i] + " tiempo ocupado");
            columnasList.add(tiposServidores[i] + " tiempo total");
        }
        String[] columnas = columnasList.toArray(new String[0]);

        modelo = new DefaultTableModel(columnas, 0);
        tablaResultados.setModel(modelo);


        tablaResultados.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        for (Object[] fila : simulacion.getResultados()) {
            modelo.addRow(fila);
        }


        scrollPane.setViewportView(tablaResultados);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        outputPanel.setLayout(new BorderLayout());
        outputPanel.add(scrollPane, BorderLayout.CENTER);


        setVisible(true);
    }

    private void initComponents() {
        outputPanel = new JPanel();
        tablaResultados = new JTable();
        scrollPane = new JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(outputPanel, GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(outputPanel, GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
                                .addContainerGap())
        );


        pack();
    }

}
