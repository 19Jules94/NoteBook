/*
 * Definicion de la clase Medico
 */

package es.uvigo.esei.pro2.core;

import nu.xom.*;

/**
 *
 * @author Nani
 */
public class Medico extends Persona {

    public String TagMedico = "medico";
    public String TagNumColegiado = "numColegiado";
    private String numColegiado; // Numero de colegiado del médico
  

    /** Crea un nuevo médico, con sus datos: numero colegiado, nombre y
     *  domicilio 
     * @param numColegiado número colegiado del médico
     * @param nombre nombre completo del médico
     * @param domicilio  el domicilio del médico
     */
    public Medico( String nombre, String domicilio, String numColegiado)
    {
        super(nombre, domicilio);
        this.setNumColegiado( numColegiado );
    }

    public Medico (Element e) throws ParsingException {

        super(e);

        Element eltoNumColegiado = e.getFirstChildElement(TagNumColegiado);

        if(eltoNumColegiado == null){


            throw new ParsingException("Falta el numero de colegiado en el elemento");
        }
            this.numColegiado=eltoNumColegiado.getValue();


    }
    
    /** Devuelve el número de colegiado del médico 
     * @return el numColegiado del medico, como String.
     */    
    public String getNumColegiado()
    {
        return numColegiado;
    }

    /** Cambia el  número de colegiado del médico 
     * @param numColegiado el numColegiado del médico
     */    
    public void setNumColegiado(String numColegiado)
    {
        this.numColegiado = numColegiado;
    }    
    
    @Override
    public String toString()
    {
        StringBuilder toret = new StringBuilder();
        
        toret.append(super.toString());
        toret.append(getNumColegiado()).append(" ; ");
             
        return toret.toString();
    }

    public Element toDOM() {
        Element toret = super.toDOM();
        Element eltoNumColegiado = new Element(TagNumColegiado);
        eltoNumColegiado.appendChild(numColegiado);
        toret.setLocalName(TagMedico);
        toret.appendChild(eltoNumColegiado);
        return toret;
    }
}
