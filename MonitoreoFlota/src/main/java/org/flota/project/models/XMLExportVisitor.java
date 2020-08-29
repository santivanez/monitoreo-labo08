package org.flota.project.models;

import org.flota.project.patterns.XMLVisitor;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XMLExportVisitor implements XMLVisitor {

    @Override
    public String visitRecojo(Recojo recojo) {
        String xmlStr = "<root><recojo><comentarios>" + recojo.getComentarios()+
                        "</comentarios><direccion>"+ recojo.getDireccion()+
                        "</direccion><peso-paquete>" + recojo.getPeso() +
                        "</peso-paquete></recojo></root>";
        System.out.println(format(xmlStr));
        return format(xmlStr);
    }

    @Override
    public String visitDespacho(Despacho despacho) {
        String xmlStr = "<root><despacho><comentarios>"+ despacho.getComentarios()+
                        "</comentarios><direccion>"+ despacho.getDireccion()+
                        "</direccion><documento>"+ despacho.getDireccion()+
                        "</documento><peso-paquete>" + despacho.getPeso() +
                        "</peso-paquete></despacho></root>";
        System.out.println(format(xmlStr));
        return format(xmlStr);
    }

    @Override
    public String visitFueraDeLinea(FueraDeLinea fueraDeLinea) {
        String xmlStr = "<root><fueralinea><evento>"+ fueraDeLinea.getEvento() +
                        "</evento></fueralinea></root>";
        System.out.println(format(xmlStr));
        return format(xmlStr);
    }

    public String format(String input) {
        return prettyFormat(input, "2");
    }

    public static String prettyFormat(String input, String indent) {
        Source xmlInput = new StreamSource(new StringReader(input));
        StringWriter stringWriter = new StringWriter();
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, "yes");
            transformer.setOutputProperty("{https://xml.apache.org/xslt}indent-amount", indent);
            transformer.transform(xmlInput, new StreamResult(stringWriter));

            return stringWriter.toString().trim();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}