package org.flota.project.models;

public class Camion extends Vehiculo{

    private String anio;

    public Camion() {
        super(15, 100.0);
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

}
