package org.flota.project.patterns;

import org.flota.project.models.Ruta;


public interface RutaStrategy {

    Ruta crearRuta();

    boolean validarPuntos();

    boolean validarPeso();

}
