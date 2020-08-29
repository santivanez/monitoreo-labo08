package org.flota.project.models;

public class Moto extends Vehiculo {

    private String modelo;

    public Moto() {
        super(10, 20.0);
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
