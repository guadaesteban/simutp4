package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        int cantServicios = 6;
        double[] rndLlegadas = new double[cantServicios];
        double[] proxLlegadas = new double[cantServicios];
        Object[] rndServicio = new Object[cantServicios];
        Object[] tiempo = new Object[cantServicios];

        for (int i = 0; i < cantServicios; i++) {
            rndLlegadas[i] = Math.random();
            proxLlegadas[i] = rndLlegadas[i];
            tiempo[i] = null;
            rndServicio[i] = null;
        }

        resultados.add(new Object[]{evento, reloj,servicios, rndLlegadas, tiempo, proxLlegadas, rndServicio});

        //for (int i=0; i < cantidadSimulaciones; i++){
               //
        //}




        //List<double> llegada = new List<double>();
        //llegada = simularPorServicio(rnd, tiempo, proxLlegada);
    }

   // private List<Object> simularPorServicio(double rnd,double tiempo,double proxLlegada){

   // }

   // private double calcularProximoEvento(){    }

    public List<Object[]> getResultados() {
        return resultados;
    }
}
