package org.flota.project.models;

import org.flota.project.patterns.RutaStrategy;

import java.util.ArrayList;

public class CamionRutaStrategy implements RutaStrategy {

    private int puntosActuales = 0;
    private Double pesoActual = 0.0;

    @Override
    public Ruta crearRuta() {
        Ruta ruta = new Ruta();

        ruta.addPunto(new Recojo(-77.0844, -12.0561, "Las Garzas", "Urgente", 2.1));
        ruta.addPunto(new Despacho(-77.083665, -12.054374, "Jazmines 432", "Normal", "1234321", 1.0));
        ruta.addPunto(new Despacho(-77.080250, -12.056479, "Jazmines 670", "Normal", "7879088", 0.9));
        ruta.addPunto(new Despacho(-77.077908, -12.065964, "Calle Alfonso Ugarte", "Urgente", "7867521", 1.0));
        ruta.addPunto(new Despacho(-77.078538, -12.073385, "Teodoro Vargas", "Normal", "9043321", 3.0));
        ruta.addPunto(new Despacho(-77.081588, -12.077808, "Las Flores Sur", "Urgente", "54574321", 1.0));
        return ruta;
    }

    @Override
    public boolean validarPuntos() {
        return false;
    }

    @Override
    public boolean validarPeso() {
        return false;
    }
}
