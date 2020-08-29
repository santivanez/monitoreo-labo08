package org.flota.project.models;

import org.flota.project.patterns.Visitor;
import org.flota.project.patterns.XMLVisitor;

public class Recojo extends Punto {

    private String direccion;
    private String comentarios;

    public Recojo(double lon, double lat, double pes) {
        super(lon, lat, pes);
    }

    public Recojo(double lon, double lat, String direccion, String comentarios, Double pesoItem) {
        super(lon, lat, pesoItem);
        this.direccion = direccion;
        this.comentarios = comentarios;
    }

    public String getDireccion(){
        return direccion;
    }

    public String getComentarios(){
        return comentarios;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitRecojo(this);
    }

    @Override
    public void accept(XMLVisitor visitor) {
        visitor.visitRecojo(this);
    }


}
