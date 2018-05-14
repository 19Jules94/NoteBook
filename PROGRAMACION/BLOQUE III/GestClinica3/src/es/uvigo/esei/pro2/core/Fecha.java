/*
 * Definicion de la clase Fecha
 */

package es.uvigo.esei.pro2.core;

import nu.xom.Element;
import nu.xom.ParsingException;

/**
 *
 * @author Nani
 */
public class Fecha {
    public static final String tagFecha = "fecha";
    public static final String tagDia = "dia";
    public static final String tagMes = "mes";
    public static final String tagAnho= "anho";

    private int dia;
    private int mes;
    private int anho;

    public Fecha(int dia, int mes, int anho) {
        this.dia = dia;
        this.mes = mes;
        this.anho = anho;
    }

    public Fecha(Element e) throws ParsingException {

        Element eltoDia = e.getFirstChildElement(tagDia);
        Element eltoMes = e.getFirstChildElement(tagMes);
        Element eltoAnho = e.getFirstChildElement(tagAnho);

        if(eltoDia == null){

            throw  new ParsingException("Falta el dia");

        }
        if(eltoMes == null){

            throw  new ParsingException("Falta el mes");

        }
        if(eltoAnho == null){

            throw  new ParsingException("Falta el anho");

        }

        this.dia = Integer.parseInt(eltoDia.getValue().trim());
        this.mes = Integer.parseInt(eltoMes.getValue().trim());
        this.anho = Integer.parseInt(eltoAnho.getValue().trim());


    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAnho() {
        return anho;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public void setAnho(int anho) {
        this.anho = anho;
    }


    public Element toDOM(){

        Element root = new Element(tagFecha);
        Element eltoDia = new Element(tagDia);
        Element eltoMes = new Element(tagMes);
        Element eltoAnho = new Element(tagAnho);

        eltoDia.appendChild(Integer.toString(getDia()));
        eltoMes.appendChild(Integer.toString(getMes()));
        eltoAnho.appendChild(Integer.toString(getAnho()));

        root.appendChild(eltoDia);
        root.appendChild(eltoMes);
        root.appendChild(eltoAnho);

        return root;

    }
    
    @Override
    public String toString() {
        StringBuilder toret = new StringBuilder();
        
        toret.append (getDia());
        toret.append ("/");
        toret.append (getMes());
        toret.append ("/");
        toret.append (getAnho());
        
        return toret.toString();
    }
        
}
