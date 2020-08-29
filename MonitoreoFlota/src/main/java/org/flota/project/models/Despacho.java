package org.flota.project.models;

import org.flota.project.patterns.Visitor;
import org.flota.project.patterns.XMLVisitor;

public class Despacho extends Punto {
    private String direccion;
    private String comentarios;
    private String documento;

    public Despacho(double lon, double lat, double pes) {
        super(lon, lat, pes);
    }

    public Despacho(double lon, double lat, String direccion, String comentarios, String documento, double pesoItem) {
        super(lon, lat, pesoItem);
        this.direccion = direccion;
        this.comentarios = comentarios;
        this.documento = documento;
    }

    public String getDireccion(){
        return direccion;
    }

    public String getComentarios(){
        return comentarios;
    }

    public String getDocumento(){
        return documento;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitDespacho(this);
    }

    @Override
    public void accept(XMLVisitor visitor) {
        visitor.visitDespacho(this);
    }
}
