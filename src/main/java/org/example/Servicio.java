package org.example;

public class Servicio {
    private String tipo;
    private Servidor[] servidores;
    private double tasaLlegada;
    private double tasaServicio;
    private int cola;
    private double tiempoOcupado;
    private double tiempoTotal;


    public Servicio(String tipo, int nroServidores, double tasaLlegada, double tasaServicio) {
        this.tipo = tipo;
        this.servidores = new Servidor[nroServidores];
        for (int i = 0; i < nroServidores; i++) {
            this.servidores[i] = new Servidor();
            this.servidores[i].setNro(i + 1);
            this.servidores[i].setEstado("libre");
        }
        this.tasaLlegada = tasaLlegada;
        this.tasaServicio = tasaServicio;
        this.cola = 0;
        this.tiempoOcupado = 0.0;
        this.tiempoTotal = 0.0;
    }

    public Servidor[] getServidores() {
        return servidores;
    }

    public void setServidores(Servidor[] servidores) {
        this.servidores = servidores;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    public double getTiempoOcupado() {
        return tiempoOcupado;
    }

    public void setTiempoOcupado(double tiempoOcupado) {
        this.tiempoOcupado = tiempoOcupado;
    }

    public double getTiempoTotal() {
        return tiempoTotal;
    }

    public void setTiempoTotal(double tiempoTotal) {
        this.tiempoTotal = tiempoTotal;
    }


}
