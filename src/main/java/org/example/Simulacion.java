package org.example;

import java.util.ArrayList;
import java.util.List;


public class Simulacion {
    private List<Servicio> servicios;
    private int cantidadSimulaciones;
    private int desde;
    private int hasta;
    private double prestamoTL;
    private double devolucionTL;
    private double consultaTL;
    private double accesoPcTL;
    private double infoTL;
    private double extraTL;
    private double prestamoTS;
    private double devolucionTS;
    private double consultaTS;
    private double accesoPcTS;
    private double infoTS;
    private double extraTS;
    private List<Object[]> resultados;

    public Simulacion(int cantidadSimulaciones, int desde, int hasta,
                      double prestamoTL, double devolucionTL, double consultaTL, double accesoPcTL,
                      double infoTL, double extraTL, double prestamoTS, double devolucionTS,
                      double consultaTS, double accesoPcTS, double infoTS, double extraTS) {
        this.cantidadSimulaciones = cantidadSimulaciones;
        this.desde = desde;
        this.hasta = hasta;
        this.prestamoTL = prestamoTL;
        this.devolucionTL = devolucionTL;
        this.consultaTL = consultaTL;
        this.accesoPcTL = accesoPcTL;
        this.infoTL = infoTL;
        this.extraTL = extraTL;
        this.prestamoTS = prestamoTS;
        this.devolucionTS = devolucionTS;
        this.consultaTS = consultaTS;
        this.accesoPcTS = accesoPcTS;
        this.infoTS = infoTS;
        this.extraTS = extraTS;
        servicios = new ArrayList<>();
        resultados = new ArrayList<>();
        inicializarServicios();
    }

    private void inicializarServicios() {
        servicios.add(new Servicio("Préstamo de Libros", 3, prestamoTL, prestamoTS));
        servicios.add(new Servicio("Devolución de Libros", 2, devolucionTL, consultaTL));
        servicios.add(new Servicio("Consulta en Sala", 2, consultaTL, consultaTS));
        servicios.add(new Servicio("Acceso a Computadoras", 1, accesoPcTL, accesoPcTS));
        servicios.add(new Servicio("Información General", 2, infoTL, infoTS));
        servicios.add(new Servicio("Servicio extra", 1, extraTL, extraTS));

    }

    public void simular(){
        //fila 1 de inicializacion
        String evento = "inicializacion";
        double reloj = 0.0;
        int cantServicios = servicios.size();
        double[][] llegadas = new double[cantServicios][3];


        for (int i = 0; i < cantServicios; i++) {
            llegadas[i] = calcularProximoEvento(reloj, servicios.get(i));

        }

        resultados.add(new Object[]{evento, reloj, llegadas, servicios});

    }

   private double[] calcularProximoEvento(double reloj, Servicio servicio){
        double rnd = Math.random();
        double tiempo = (-servicio.getTasaLlegada()) * Math.log(1 - rnd);
        double proxLlegada = reloj + tiempo;

        return new double[]{rnd, tiempo, proxLlegada};
   }

    public List<Object[]> getResultados() {
        return resultados;
    }

    public List<Servicio> getServicios() { return servicios;    }
}
