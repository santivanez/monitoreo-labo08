package org.flota.project.models;

import com.esri.arcgisruntime.geometry.Point;
import org.flota.project.patterns.Visitor;
import org.flota.project.patterns.XMLVisitor;

public abstract class Punto {

    private double latitud;
    private double longitud;
    private Point point;
    private Double peso;

    public Punto(double lon, double lat, Double pes){
        latitud = lat;
        longitud = lon;
        peso = pes;
        point = new Point(lon, lat);
    }

    public Punto(double lon, double lat) {
        latitud = lat;
        longitud = lon;
        point = new Point(lon, lat);
    }

    public Point getPoint(){
        return point;
    }

    public Double getPeso() {
        return peso;
    }

    public abstract void accept(Visitor visitor);

    public abstract void accept(XMLVisitor visitor);

}
