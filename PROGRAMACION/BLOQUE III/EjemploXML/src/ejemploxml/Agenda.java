
package ejemploxml;

import java.util.*;
import java.lang.*;
import java.io.*;
import nu.xom.*;

/**
 *
 * @author pcuesta
 */

 /** Gestionar el contenedor de contactos  */
public class Agenda {
    public static final String EtqAgenda = "agenda";
 
    /*** Excepción a lanzar cuando se pide una posición incorrecta */
    public static class PosicionIncorrecta extends Exception{
        public PosicionIncorrecta (String exc){
            super(exc);
        }
    }
 
    private ArrayList <Contacto> agenda;
 
    /*** Prepara una agenda vacía */
    public Agenda(){
        agenda = new ArrayList<>();
    }
 
    /*** Carga una agenda desde XML 
    * @param nf la ruta del fichero XML, como String
     */
    public Agenda(String nf) throws ParsingException, IOException {
        this();    
        Builder parser = new Builder();
        Document doc = parser.build( new File( nf ) );
 
        Elements contactos = doc.getRootElement().getChildElements();
         
        for(int i = 0; i < contactos.size(); i++) {
            Element eltoContacto = contactos.get(i);
            if (eltoContacto.getLocalName().equals(Pareja.EtqPareja)){
                this.inserta(new Pareja(eltoContacto));
            } else if (eltoContacto.getLocalName().equals(Instagram.EtqInstagram)){ 
                this.inserta(new Instagram(eltoContacto));
            }
            else {
                this.inserta(new Contacto(eltoContacto));
            }
        }
    }
 
    /** inserta un contacto en la agenda
     * @param c, el contacto a insertar 
     */
    public void inserta(Contacto c) {
        agenda.add( c );
    }
 
    /** devuelve el número de contactos de la agenda
     * @return número de contactos de la agenda 
     */
    public int getNum() {
        return agenda.size();
    }
 
    /** obtiene un contacto del contenedor
     * 
     * @param i posición del contacto a recuperar
     * @return el contacto que está en la posición i
     * @throws ejemploxml.Agenda.PosicionIncorrecta 
     */
    public Contacto get (int i) throws PosicionIncorrecta{
        if( i < 0 || i > getNum())
        {
            throw new PosicionIncorrecta( "No cumple el rango de elementos" );
        } else {
            return agenda.get(i);
        }
 
    }
    
    /**
    * Devuelve el objeto Contacto guardado que se
    * corresponde con el email. Es un recorrido secuencial.
    * @param email El email a buscar
    * @return El objeto Contacto, o null si no existe
    * @throws ejemploxml.Agenda.PosicionIncorrecta 
    */
    public Contacto get(String email) throws PosicionIncorrecta 
    {
        Contacto toret = null;
        email = email.trim();
        for(int i = 0; i < this.getNum(); ++i) {
            Contacto p = get( i );
            if ( p.getEmail().equals( email ) ) {
                toret = p;
                break;
            }
        }
        return toret;
    }
 
   public String toString(){
        StringBuilder s = new StringBuilder();
 
        for(int i = 0; i < getNum();i++){
            s.append(agenda.get(i).toString()+"\n");
        }
 
        return s.toString();
    }
 
    /** construye el DOM a partir de los objetos almancenados en la agenda
     * @return nodo raiz, de tipo Element 
     */
    public Element toDom(){
 
        Element toRet = new Element( EtqAgenda );
         
        for(int i = 0; i < getNum();i++){
 
            toRet.appendChild(agenda.get(i).toDOM());
        }
        return toRet;
    }
 
    /** Almacena en un fichero XML los contactos de la agenda
     * @param nf ruta del fichero, como un String
     * @throws IOException 
     */
    public void toXML(String nf) throws IOException
    {
        FileOutputStream f = new FileOutputStream( nf );
        Serializer serial = new Serializer( f );
        Document doc = new Document( this.toDom() );
        serial.write(doc);
    }
}
