package org.flota.project.patterns;

import org.flota.project.models.Despacho;
import org.flota.project.models.FueraDeLinea;
import org.flota.project.models.Recojo;

import java.util.Map;

public interface XMLVisitor {

    String visitRecojo(Recojo recojo);
    String visitDespacho(Despacho despacho);
    String visitFueraDeLinea(FueraDeLinea fueraDeLinea);

}
