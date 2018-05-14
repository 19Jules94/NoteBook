/*
 * Definicion de la clase Hora
 */

package es.uvigo.esei.pro2.core;

import nu.xom.*;


/**
 *
 * @author Nani
 */
public class Hora {
    public String EtHora = "hora";
    public String TagHora = "hora";
    public String TagMinutos = "minutos";
    private int hora;
    private int minutos;

    /** Crea una nueva hora, con sus datos: hora y minutos
     * @param hora hora
     * @param minutos minutos
     */
    public Hora(int hora, int minutos) {
        this.hora = hora;
        this.minutos = minutos;
    }
    public Hora(Element e) throws ParsingException {
        Element eltoHora = e.getFirstChildElement(TagHora);
        Element eltoMin = e.getFirstChildElement(TagMinutos);

        if(eltoHora == null){

            throw new ParsingException( "Falta la hora el elemento contacto" );

        }
        if(eltoMin == null){

            throw new ParsingException( "Falta los minutos en el elemento contacto" );

        }
        try{
            this.hora = Integer.parseInt(eltoHora.getValue().trim());
            this.minutos = Integer.parseInt(eltoMin.getValue().trim());
        }catch(NumberFormatException exc) {
            throw new ParsingException("Valor incorrecto para la hora");
        }

        try{

            this.minutos = Integer.parseInt(eltoMin.getValue().trim());
        }catch(NumberFormatException exc) {
            throw new ParsingException("Valor incorrecto para los minutos");
        }

    }

    /** Devuelve la hora 
     * @return la hora, como int.
     */ 
    public int getHora() {
        return hora;
    }
    
    /** Devuelve los minutosss
     * @return los minutos, como int.
     */ 
    public int getMinutos() {
        return minutos;
    }

   /** Cambia la hora
     * @param hora la hora
     */  
    public void setHora(int hora) {
        this.hora = hora;
    }
    
   /** Cambia los minutos
     * @param minutos los minutos
     */  
    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }
    
    @Override
    public String toString()
    {
        StringBuilder toret = new StringBuilder();
        
        toret.append("(").append(getHora())
             .append(":").append(getMinutos())
             .append(")");
             
        return toret.toString();
    }

    public Element toDOM(){
        Element raiz = new Element ( EtHora );
        Element eltoHora = new Element ( TagHora );
        Element eltoMinutos = new Element( TagMinutos );


        eltoHora.appendChild(Integer.toString(hora));
        eltoMinutos.appendChild(Integer.toString(minutos));

        raiz.appendChild(eltoHora);
        raiz.appendChild(eltoMinutos);


        return raiz;
    }

    
}
