/*
 * Definicion de la clase CitaMedica
 */
package es.uvigo.esei.pro2.core;

import nu.xom.*;
import nu.xom.ParsingException;

/**
 *
 * @author Nani
 */
public class CitaMedica {

    public static final String tagCitaMedica = "citaMedica";
    public static final String tagPaciente = "paciente";
    public static final String tagMedico = "medico";
    public static final String tagFechaCita = "fechaCita";
    public static final String tagHoraCita = "horaCita";

    private Paciente paciente;
    private Medico medico;
    private Fecha fechaCita;
    private Hora horaCita;

    /** Crea una nueva cita médica, con sus datos: paciente, medico,
     *  fecha y hora de la cita
     * @param paciente paciente 
     * @param medico médico
     * @param fechaCita  fecha de la cita médica

     */
    public CitaMedica(Paciente paciente, Medico medico, Fecha fechaCita, 
            Hora horaCita) {
        this.paciente = paciente;
        this.medico = medico;
        this.fechaCita = fechaCita;
        this.horaCita = horaCita;
    }

    public CitaMedica(Element e) throws ParsingException {

        Element eltoPaciente = e.getFirstChildElement(tagPaciente);
        Element eltoMedico = e.getFirstChildElement(tagMedico);
        Element eltoCita = e.getFirstChildElement(tagFechaCita);
        Element eltoHora = e.getFirstChildElement(tagHoraCita);

        if(eltoPaciente == null){

            throw new ParsingException("falta el paciente");

        }

        if(eltoMedico == null){

            throw new ParsingException("falta el medico");

        }

        if(eltoCita == null){

            throw new ParsingException("falta la cita");

        }

        if(eltoHora == null){

            throw new ParsingException("falta la hora");

        }

        this.paciente = new Paciente(eltoPaciente){};
        this.medico = new Medico(eltoMedico);
        this.fechaCita = new Fecha(eltoCita);
        this.horaCita = new Hora(eltoHora);

    }

    /** Devuelve el paciente involucrado en la cita medica 
     * @return el paciente, como Paciente.
     */     
    public Paciente getPaciente() {
        return paciente;
    }
    
    /** Devuelve el medico involucrado en la cita medica 
     * @return el medico, como Medico.
     */    
    public Medico getMedico() {
        return medico;
    }

   /** Devuelve la fecha de la cita medica 
     * @return fechaCita, como Fecha.
     */ 
    public Fecha getFechaCita() {
        return fechaCita;
    }

   /** Devuelve la hora de la cita medica 
     * @return horaCita, como Hora.
     */     
    public Hora getHoraCita() {
        return horaCita;
    }
    
    /** Cambia el paciente involucrado en la cita médica
     * @param paciente el paciente
     */    
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    
    /** Cambia el medico involucrado en la cita médica
     * @param medico el medico
     */  
    public void setMedico(Medico medico) {
        this.medico = medico;
    }
    
    /** Cambia la fecha de la cita médica
     * @param fechaCita la fecha
     */  
    public void setFechaCita(Fecha fechaCita) {
        this.fechaCita = fechaCita;
    }
    
    /** Cambia la hora de la cita médica
     * @param horaCita la Hora
     */ 
    public void setHoraCita(Hora horaCita) {
        this.horaCita = horaCita;
    }



    public Element toDOM(){

        Element root = new Element(tagCitaMedica);
        Element eltoMedico = getMedico().toDOM();
        Element eltoPaciente = getPaciente().toDOM();
        Element eltoFecha = getFechaCita().toDOM();
        Element eltoHora = getHoraCita().toDOM();

        eltoMedico.appendChild(tagMedico);
        eltoPaciente.appendChild(tagPaciente);
        eltoFecha.appendChild(tagFechaCita);
        eltoHora.appendChild(tagHoraCita);


        root.appendChild(eltoMedico);
        root.appendChild(eltoPaciente);
        root.appendChild(eltoFecha);
        root.appendChild(eltoHora);

        return root;
    }
    
    @Override
    public String toString()
    {
        StringBuilder toret = new StringBuilder();
        
        toret.append("La cita medica es:\n ")
             .append("\tPaciente: ").append(getPaciente())
             .append("\tMedico: ").append(getMedico())
             .append("\tFecha/Hora: ").append(getFechaCita())
             .append("/").append(getHoraCita());
             
        return toret.toString();
    } 
    
}
