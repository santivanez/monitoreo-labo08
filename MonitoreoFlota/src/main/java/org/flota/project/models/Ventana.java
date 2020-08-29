package org.flota.project.models;

import com.esri.arcgisruntime.geometry.PointCollection;
import com.esri.arcgisruntime.geometry.Polyline;
import com.esri.arcgisruntime.symbology.SimpleLineSymbol;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import com.esri.arcgisruntime.mapping.view.GraphicsOverlay;
import com.esri.arcgisruntime.geometry.Point;
import com.esri.arcgisruntime.geometry.SpatialReferences;
import com.esri.arcgisruntime.mapping.view.Graphic;
import com.esri.arcgisruntime.symbology.SimpleMarkerSymbol;
import org.flota.project.patterns.Context;

import java.util.Arrays;

public class Ventana extends Application {

    private Mapa mapaBase;

    @Override
    public void start(Stage stage) throws Exception {

        // set the title and size of the stage and show it
        stage.setTitle("Sistema de Monitoreo de Vehiculos");
        stage.setWidth(800);
        stage.setHeight(700);
        stage.show();

        // create a JavaFX scene with a stack pane as the root node and add it to the scene
        StackPane stackPane = new StackPane();
        Scene scene = new Scene(stackPane);
        stage.setScene(scene);

        // create a MapView to display the map and add it to the stack pane
        /*
        this.mapaBase = new Mapa();
        this.mapaBase.imprimeCoordenadasActual();
        stackPane.getChildren().add(this.mapaBase.getMapView());
        */
        //mapaBase = new Mapa();
        //mapaBase.imprimeCoordenadasActual();
        //stackPane.getChildren().add(mapaBase.getMapView());
        FachadaMapa facade = new FachadaMapa();
        mapaBase = facade.mostrarMapa(stackPane);

        Button btnNuevo = new Button();
        btnNuevo.setText("Nuevo");
        btnNuevo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                muestraNuevaVentana();
            }
        });

        stackPane.getChildren().add(btnNuevo);



        // create a graphics overlay for displaying different geometries as graphics
        GraphicsOverlay graphicsOverlay = new GraphicsOverlay();
        mapaBase.getMapView().getGraphicsOverlays().add(graphicsOverlay);

        // create a point geometry
        Point point = new Point(-77.0844, -12.0561, SpatialReferences.getWgs84());
        Graphic pointGraphic = new Graphic(point, new SimpleMarkerSymbol(SimpleMarkerSymbol.Style.DIAMOND, 0xFF0000FF, 14));

        graphicsOverlay.getGraphics().addAll(Arrays.asList(pointGraphic));
        //graphicsOverlay.getGraphics().remove(point);
        //stackPane.getChildren().addAll(mapaBase.getMapView());


        /* Context */

        Context context = new Context();
        //context.setStrategy(new CamionRutaStrategy());
        //context.setStrategy(new MotoRutaStrategy());
        context.setStrategy(new MinivanRutaStrategy());
        Ruta ruta = context.crearRuta();
        context.permiteMasPuntos();
        context.permiteMasPeso();

        Moto moto = new Moto();
        moto.toString();


        PointCollection polylinePoints = new PointCollection(SpatialReferences.getWgs84());

        polylinePoints.addAll(ruta.getPoints());

        Polyline polyline = new Polyline(polylinePoints);
        SimpleLineSymbol polylineSymbol = new SimpleLineSymbol(SimpleLineSymbol.Style.SOLID, 0xFF00FF00, 3.0f);
        Graphic polylineGraphic = new Graphic(polyline, polylineSymbol);
        graphicsOverlay.getGraphics().add(polylineGraphic);


        JSONExportVisitor jsonVisitor = new JSONExportVisitor();
        for (Punto punto : ruta.getPuntos()){
            punto.accept(jsonVisitor);
        }

        XMLExportVisitor xmlVisitor = new XMLExportVisitor();
        for(Punto punto: ruta.getPuntos()){
            punto.accept(xmlVisitor);
        }

    }

    public void muestraNuevaVentana() {
        Stage stage = new Stage();
        StackPane stackPane = new StackPane();
        Scene scene = new Scene(stackPane);
        stage.setScene(scene);

        //  Clonacion de MapaBase
        Mapa mapaBase2 = (Mapa)mapaBase.copiar();

        mapaBase2.imprimeCoordenadasActual();
        stackPane.getChildren().add(mapaBase2.getMapView());

        stage.show();
    }

}