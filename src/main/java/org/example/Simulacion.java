package org.example;

import java.util.ArrayList;
import java.util.List;

public class Simulacion {
    private List<Servicio> servicios;

    public Simulacion() {
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
}
