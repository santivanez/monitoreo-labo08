package org.flota.project.models;

public abstract class Vehiculo {

    private String id; // uuid
    private String estado; // ocupado/libre
    private Double capacidadAncho;
    private Double capacidadLargo;

    private int maxPuntos;
    private double maxCapacidad;

    public Vehiculo() {
    }

    public Vehiculo(int maxPuntos, double maxCapacidad) {
        this.maxPuntos = maxPuntos;
        this.maxCapacidad = maxCapacidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setMaxPuntos(int maxPuntos) {
        this.maxPuntos = maxPuntos;
    }

    public void setMaxCapacidad(Double maxCapacidad) {
        this.maxCapacidad = maxCapacidad;
    }

    public int getMaxPuntos() {
        return maxPuntos;
    }

    public Double getMaxCapacidad() {
        return maxCapacidad;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "id='" + id + '\'' +
                ", estado='" + estado + '\'' +
                ", capacidadAncho=" + capacidadAncho +
                ", capacidadLargo=" + capacidadLargo +
                ", maxPuntos=" + maxPuntos +
                ", maxCapacidad=" + maxCapacidad +
                '}';
    }
}