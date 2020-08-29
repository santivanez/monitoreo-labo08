package org.flota.project.models;

import org.flota.project.patterns.RutaStrategy;

import java.util.ArrayList;

public class MinivanRutaStrategy extends Minivan implements RutaStrategy {

    private int puntosActuales = 0;
    private double pesoActual = 0.0;

    public MinivanRutaStrategy() {
        super();
    }

    @Override
    public Ruta crearRuta() {
        Ruta ruta = new Ruta();
        ruta.addPunto(new Recojo(-77.0844, -12.0561, "Jazmines", "Normal", 2.0));
        ruta.addPunto(new Despacho(-77.084774, -12.055502, "Las Torres", "Normal", "7874321", 2.0));
        ruta.addPunto(new Despacho(-77.085750, -12.057957, "Los Suaces", "Urgente", "3324321", 2.0));
        ruta.addPunto(new Despacho(-77.084760, -12.058826, "Av. Sol 434", "Normal", "7879876", 2.0));
        ruta.addPunto(new Recojo(-77.086194, -12.061448, "Calle 22", "Urgente", 234234.0));
        ruta.addPunto(new FueraDeLinea(-77.084516, -12.078045, "Almuerzo"));
        this.puntosActuales = ruta.getPoints().size();
        getPesoActual(ruta);
        return ruta;
    }

    @Override
    public boolean validarPuntos() {
        if ( puntosActuales <= this.getMaxPuntos()){
            System.out.println("Número de puntos permitido");
            return true;
        } else {
            System.out.println("No puede realizarse la ruta. Exceso de npumero de puntos");
            return false;
        }
    }

    @Override
    public boolean validarPeso() {
        if ( pesoActual<= this.getMaxCapacidad()){
            System.out.println("Peso permitido");
            return true;
        } else {
            System.out.println("No puede realizarse la ruta. Exceso de peso");
            return false;
        }
    }

    private void getPesoActual(Ruta ruta) {
        ArrayList<Punto> puntosEnRuta = ruta.getPuntos();
        for (Punto punto : puntosEnRuta) {
            this.pesoActual = this.pesoActual + punto.getPeso();
        }
    }


}
