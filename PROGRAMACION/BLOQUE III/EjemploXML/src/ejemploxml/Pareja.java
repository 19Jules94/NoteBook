/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemploxml;

import nu.xom.*;

/**
 *
 * @author José María Martínez Penedo
 */
public class Pareja extends Contacto{
    public static final String EtqPareja = "pareja";
    public static final String EtqFecha = "fecha";
    private Fecha fecha;
    
    public Pareja(String nombre, String email, int telefono,Fecha fecha){
        super(nombre,email,telefono);
        this.fecha = fecha;
    }
    /** Crea una  nueva Pareja, desde un Element de XML
    * @param e El objeto Element de XML
    */
    public Pareja (Element e) throws ParsingException {
        super(e);
        Element eltoFecha = e.getFirstChildElement( Fecha.EtqFecha );
        if ( eltoFecha == null ) {
            throw new ParsingException( "falta la fecha en el elemento" );
        }
        this.fecha = new Fecha(eltoFecha);
    }
    public void setFecha(Fecha fecha){
        this.fecha=fecha;
    }
    public Fecha getFecha(){
        return this.fecha;
    }
    @Override
    public String toString(){
        return super.toString() + String.format("Fecha: %s\n", this.getFecha());           
    }
    /** Devuelve un objeto Element para generar el DOM
     * @return Un objeto Element.
     */   
    @Override
    public Element toDOM(){
        Element toret = super.toDOM();
        toret.setLocalName( EtqPareja );
        toret.appendChild( getFecha().toDom() );
        return toret;
    }
}
