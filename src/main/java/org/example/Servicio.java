package org.example;

public class Servicio {
    private String tipo;
    private int nroServidores;
    private double tasaLlegada;
    private double tasaServicio;
    private int cola;


    public Servicio(String tipo, int nroServidores, double tasaLlegada, double tasaServicio, int cola) {
        this.tipo = tipo;
        this.nroServidores = nroServidores;
        this.tasaLlegada = tasaLlegada;
        this.tasaServicio = tasaServicio;
        this.cola = cola;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getNroServidores() {
        return nroServidores;
    }

    public void setNroServidores(int nroServidores) {
        this.nroServidores = nroServidores;
    }

    public double getTasaLlegada() {
        return tasaLlegada;
    }

    public void setTasaLlegada(double tasaLlegada) {
        this.tasaLlegada = tasaLlegada;
    }

    public double getTasaServicio() {
        return tasaServicio;
    }

    public void setTasaServicio(double tasaServicio) {
        this.tasaServicio = tasaServicio;
    }

    public int getCola() {
        return cola;
    }

    public void setCola(int cola) {
        this.cola = cola;
    }
}
