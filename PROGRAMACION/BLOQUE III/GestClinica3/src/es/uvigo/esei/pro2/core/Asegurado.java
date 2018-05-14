/*
 * Definicion de la clase Asegurado
 */

package es.uvigo.esei.pro2.core;

import nu.xom.Element;
import nu.xom.ParsingException;

/**
 * Paciente que esta asegurado por una compañia
 * Created by nanny on 8/03/2018.
 */
public class Asegurado extends Paciente {

    public static final String tagAsegurado ="asegurado";
    public static final String tagPoliza = "poliza";
    public static final String tagCompanhia = "companhia";

    private String poliza;
    private String companhia;

     /** Crea un nuevo paciente asegurado, con sus datos: numero historial, 
      * nombre, domicilio, fecha de nacimiento, poliza y compañia
     * @param numHistorial número del historial médico
     * @param nombre nombre completo del paciente
     * @param domicilio  el domicilio del paciente
     * @param fechaNacimiento la fecha de nacimiento del paciente
     * @param poliza poliza del asegurado
     * @param companhia nombre de la compañia del asegurado
     */

    public Asegurado (String numHistorial, String nombre, String domicilio, 
                    Fecha fechanac, String poliza, String companhia)
    {
        super(numHistorial, nombre, domicilio, fechanac);
        this.setPoliza(poliza);
        this.setCompanhia(companhia);
    }

    public Asegurado (Element e) throws ParsingException {

        super(e);

        Element eltoPoliza = e.getFirstChildElement(tagPoliza);
        Element eltoCompanhia = e.getFirstChildElement(tagCompanhia);

        if (eltoPoliza == null){
            throw  new ParsingException("Falta la poliza");
        }

        if(eltoCompanhia == null){
            throw new ParsingException("Falta la companhia");
        }

        this.poliza = eltoPoliza.getValue().trim();
        this.companhia = eltoCompanhia.getValue().trim();



    }

   /** Devuelve la poliza del paciente
     * @return la poliza del paciente, como String.
     */    
    public String getPoliza() {
        return poliza;
    }

   /** Devuelve la compañia del asegurado
     * @return la compañia del paciente, como String.
     */  
    public String getCompanhia() {
        return companhia;
    }

   /** Cambia la poliza del paciente
     * @param poliza la poliza  del paciente
     */    
    public void setPoliza(String poliza) {
        this.poliza = poliza;
    }
    
   /** Cambia la compañia del paciente
     * @param companhia la compañia del paciente
     */
    public void setCompanhia(String companhia) {
        this.companhia = companhia;
    }


    public Element toDOM(){

        Element root = super.toDOM();
        root.setLocalName(tagAsegurado);

        Element eltoPoliza = new Element(tagPoliza);
        Element eltoCompanhia = new Element(tagCompanhia);

        eltoPoliza.appendChild(getPoliza());
        eltoCompanhia.appendChild(getCompanhia());

        root.appendChild(eltoPoliza);
        root.appendChild(eltoCompanhia);

        return root;



    }

    @Override
    public String toString() {
        StringBuilder toret = new StringBuilder();
        
        toret.append("Paciente asegurado.\n");
        toret.append(super.toString());
        toret.append(getPoliza()).append(" ; ");
        toret.append(getCompanhia()).append(" ; ");      
             
        return toret.toString();
    }          
}
