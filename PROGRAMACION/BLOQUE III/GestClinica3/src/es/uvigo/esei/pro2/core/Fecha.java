/*
 * Definicion de la clase Fecha
 */

package es.uvigo.esei.pro2.core;

import nu.xom.*;

/**
 *
 * @author Nani
 */
public class Fecha {
    private int dia;
    private int mes;
    private int anho;
    public final static String EtqFecha = "fecha";
    public final static String EtqDia = "dia";
    public final static String EtqMes = "mes";
    public final static String EtqAnho = "anyo";

    public Fecha(int dia, int mes, int anho) {
        this.dia = dia;
        this.mes = mes;
        this.anho = anho;
    }
    public Fecha(Element e)  throws ParsingException{
        Element eltoDia = e.getFirstChildElement( EtqDia );
        Element eltoMes = e.getFirstChildElement( EtqMes);
        Element eltoAnho = e.getFirstChildElement( EtqAnho);
        if ( eltoDia == null ) {
            throw new ParsingException( "Falta el DIA en el elemento fecha" );
        }
        if ( eltoMes == null ) {
            throw new ParsingException( "Falta el MES en el elemento fecha" );
        }
        if ( eltoAnho == null ) {
            throw new ParsingException( "Falta el ANHO en el elemento fecha" );
        }
        this.dia =  Integer.parseInt(eltoDia.getValue().trim());
        this.mes =  Integer.parseInt(eltoMes.getValue().trim());
        this.anho =  Integer.parseInt(eltoAnho.getValue().trim());
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

    public Element toDom(){
        Element raiz = new Element ( EtqFecha );
        Element eltoDia = new Element ( EtqDia );
        Element eltoMes = new Element( EtqMes );
        Element eltoAnho = new Element ( EtqAnho );

        eltoDia.appendChild(Integer.toString(dia));
        eltoMes.appendChild(Integer.toString(mes));
        eltoAnho.appendChild(Integer.toString(anho));

        raiz.appendChild(eltoDia);
        raiz.appendChild(eltoMes);
        raiz.appendChild(eltoAnho);

        return raiz;
    }
        
}
