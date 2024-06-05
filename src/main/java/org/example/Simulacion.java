package org.example;

import java.util.ArrayList;
import java.util.List;

public class Simulacion {
    private List<Servicio> servicios;
    private int cantidadSimulaciones;
    private int desde;
    private int hasta;


    public Simulacion(int cantidadSimulaciones, int desde, int hasta) {
        this.cantidadSimulaciones = cantidadSimulaciones;
        this.desde = desde;
        this.hasta = hasta;
        servicios = new ArrayList<>();
        inicializarServicios();
    }

    private void inicializarServicios() {
        servicios.add(new Servicio("Préstamo de Libros", 3, 3, 6, 0));
        servicios.add(new Servicio("Devolución de Libros", 2, 4, 5, 0));
        servicios.add(new Servicio("Consulta en Sala", 2, 6, 7.5, 0));
        servicios.add(new Servicio("Acceso a Computadoras", 1, 7.5, 12, 0));
        servicios.add(new Servicio("Información General", 2, 2.4, 4, 0));
    }

    public List<Servicio> getServicios() {
        return servicios;
    }

    // Métodos para acceder a los parámetros pasados
    public int getCantidadSimulaciones() {
        return cantidadSimulaciones;
    }

    public int getDesde() {
        return desde;
    }

    public int getHasta() {
        return hasta;
    }
}
