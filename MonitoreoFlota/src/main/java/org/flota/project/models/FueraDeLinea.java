package org.flota.project.models;

import org.flota.project.patterns.Visitor;
import org.flota.project.patterns.XMLVisitor;

public class FueraDeLinea extends Punto{

    private String evento;

    public FueraDeLinea(double lon, double lat) {
        super(lon, lat);
    }

    public FueraDeLinea(double lon, double lat, String evento) {
        super(lon, lat);
        this.evento = evento;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitFueraDeLinea(this);
    }

    @Override
    public void accept(XMLVisitor visitor) {
        visitor.visitFueraDeLinea(this);
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

}
