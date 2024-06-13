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

        // Añadir columnas para los servidores de cada servicio
        for (Servicio servicio : simulacion.getServicios()) {
            int numServidores = servicio.getServidores().length;
            for (int j = 1; j <= numServidores; j++) {
                columnasList.add(servicio.getTipo() + " S" + j + " estado");
                columnasList.add(servicio.getTipo() + " S" + j + " rnd Duracion");
                columnasList.add(servicio.getTipo() + " S" + j + " duracion");
                columnasList.add(servicio.getTipo() + " S" + j + " fin de atencion");
            }
            columnasList.add(servicio.getTipo() + " cola");
            columnasList.add(servicio.getTipo() + " tiempo ocupado");
            columnasList.add(servicio.getTipo() + " tiempo total");
        }
        String[] columnas = columnasList.toArray(new String[0]);

        modelo = new DefaultTableModel(columnas, 0);
        tablaResultados.setModel(modelo);

        tablaResultados.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);


        for (Object[] fila : simulacion.getResultados()) {
            String evento = (String) fila[0];
            double reloj = (double) fila[1];
            double[][] llegadas = (double[][]) fila[2];
            List<Servicio> serviciosList = (List<Servicio>) fila[3];

            Object[] filaTabla = new Object[columnas.length];
            filaTabla[0] = evento;
            filaTabla[1] = reloj;

            int colIndex = 2;
            for (double[] llegada : llegadas) {
                filaTabla[colIndex++] = String.format("%.4f", llegada[0]); // RND
                filaTabla[colIndex++] = String.format("%.4f", llegada[1]); // Tiempo
                filaTabla[colIndex++] = String.format("%.4f", llegada[2]); // Próxima Llegada
            }

            colIndex = 2 + servicios.length * subColumnas.length;
            for (Servicio servicio : serviciosList) {
                for (Servidor servidor : servicio.getServidores()) {
                    filaTabla[colIndex++] = servidor.getEstado();
                    filaTabla[colIndex++] = ""; // Placeholder para rnd Duracion
                    filaTabla[colIndex++] = ""; // Placeholder para duracion
                    filaTabla[colIndex++] = ""; // Placeholder para fin de atencion
                }
                // Asignamos valores para cola, tiempo ocupado y tiempo total
                filaTabla[colIndex++] = servicio.getCola();
                filaTabla[colIndex++] = String.format("%.4f", servicio.getTiempoOcupado());
                filaTabla[colIndex++] = String.format("%.4f", servicio.getTiempoTotal());
            }

            modelo.addRow(filaTabla);
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
