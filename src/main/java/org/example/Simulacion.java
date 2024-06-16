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
        double[][] llegadas = new double[cantServicios][2];


        for (int i = 0; i < cantServicios; i++) {
            llegadas[i] = calcularProximaLlegada(reloj, servicios.get(i));

        }

        resultados.add(new Object[]{evento, reloj, llegadas, servicios});

        //fila 2 y siguientes
        for (int i = 1; i < cantidadSimulaciones; i++){
            Object[] proxEventoReloj = calcularProximoEvento(llegadas);
            evento = (String) proxEventoReloj[0];
            reloj = (Double) proxEventoReloj[1];

            resultados.add(new Object[]{evento, reloj, llegadas, servicios});
        }

    }

   private double[] calcularProximaLlegada(double reloj, Servicio servicio){
        double rnd = Math.random();
        double tiempo = (-servicio.getTasaLlegada()) * Math.log(1 - rnd);
        double proxLlegada = reloj + tiempo;

        return new double[]{rnd, tiempo, proxLlegada};
   }

    private Object[]  calcularProximoEvento(double[][] llegadas) {
        double proxReloj = Double.MAX_VALUE;
        String proxEvento = "";

        for (int i = 0; i < llegadas.length; i++) {
            double proximaLlegada = llegadas[i][2];

            if (proximaLlegada < proxReloj) {
                proxReloj = proximaLlegada;

                // Obtener el nombre del servicio correspondiente al próximo evento
                proxEvento = servicios.get(i).getTipo();
            }
        }
        return new Object[]{proxEvento, proxReloj};
    }


    public List<Object[]> getResultados() {
        return resultados;
    }

    public List<Servicio> getServicios() { return servicios;    }
}
