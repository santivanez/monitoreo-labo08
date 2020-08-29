package org.flota.project.patterns;

import org.flota.project.models.Despacho;
import org.flota.project.models.FueraDeLinea;
import org.flota.project.models.Recojo;

import java.util.Map;

public interface Visitor {
    Map<String, String> visitRecojo(Recojo recojo);
    Map<String, String> visitDespacho(Despacho despacho);
    Map<String, String> visitFueraDeLinea(FueraDeLinea fueraDeLinea);
}
