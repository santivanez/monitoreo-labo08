package org.flota.project.models;

import org.flota.project.patterns.RutaStrategy;

import java.util.ArrayList;

public class MotoRutaStrategy extends Moto implements RutaStrategy {

    private int puntosActuales = 0;
    private Double pesoActual = 0.0;

    public MotoRutaStrategy() {
        super();
    }

    @Override
    public Ruta crearRuta() {
        Ruta ruta = new Ruta();
        ruta.addPunto(new Recojo(-77.0844, -12.0561, "Jazmines", "Normal", 2.0));
        ruta.addPunto(new Despacho(-77.084774, -12.055502, "Las Torres", "Normal", "7874321", 2.0));
        ruta.addPunto(new Despacho(-77.085750, -12.057957, "Los Suaces", "Urgente", "3324321", 2.0));
        ruta.addPunto(new Despacho(-77.084760, -12.058826, "Av. Sol 434", "Normal", "7879876", 2.0));
        ruta.addPunto(new Recojo(-77.086194, -12.061448, "Calle 22", "Urgente", 2.0));
        ruta.addPunto(new Despacho(-77.082715, -12.061067, 1.0));
        ruta.addPunto(new Despacho(-77.081694, -12.067080, 1.0));
        ruta.addPunto(new Recojo(-77.083207, -12.072865, 767.0));
        ruta.addPunto(new Despacho(-77.084516, -12.078045, 1.0));
        this.puntosActuales = ruta.getPoints().size();
        getPesoActual(ruta);
        return ruta;
    }

    @Override
    public boolean validarPuntos() {
        return puntosActuales <= this.getMaxPuntos();
    }

    @Override
    public boolean validarPeso() {
        return pesoActual <= this.getMaxCapacidad();
    }

    private void getPesoActual(Ruta ruta) {
        ArrayList<Punto> puntosEnRuta = ruta.getPuntos();
        for (Punto punto : puntosEnRuta) {
            this.pesoActual = this.pesoActual + punto.getPeso();
        }
    }

}
