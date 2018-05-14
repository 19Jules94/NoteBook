/*
 * Definicion de la clase Paciente
 */
package es.uvigo.esei.pro2.core;

import nu.xom.Element;
import nu.xom.ParsingException;

/**
 * @author nrufino
 */
abstract public class Paciente extends Persona {

    public static final String tagPaciente = "paciente";
    public static final String tagNumHistorial = "numHistorial";
    public static final String tagFechaNacimiento = "fechaNacimiento";

    public enum TipoPaciente {PRIVADO, ASEGURADO}

    ;

    private String numHistorial; // Código de la historia médica 
    private Fecha fechaNacimiento;    // Fecha de nacimiento del paciente


    /**
     * Crea un nuevo paciente, con sus datos: numero historial, nombre,
     * domicilio y fecha de nacimiento
     *
     * @param numHistorial    número del historial médico
     * @param nombre          nombre completo del paciente
     * @param domicilio       el domicilio del paciente
     * @param fechaNacimiento la fecha de nacimiento del paciente
     */
    public Paciente(String nombre, String domicilio, String numHistorial,
                    Fecha fechaNacimiento) {
        super(nombre, domicilio);
        this.setNumHistorial(numHistorial);
        this.setFechaNacimiento(fechaNacimiento);
    }

    public Paciente(Element e) throws ParsingException {
        super(e);

        Element eltoNumHistorial = e.getFirstChildElement(tagNumHistorial);
        Element eltoFechaNac = e.getFirstChildElement(tagFechaNacimiento);

        if (eltoNumHistorial == null) {

            throw new ParsingException("Falfa el numero de Historial");

        }

        if (eltoFechaNac == null) {

            throw new ParsingException("Falta la fecha de Nacimiento");

        }

        this.numHistorial = eltoNumHistorial.getValue().trim();
        this.fechaNacimiento = new Fecha(eltoFechaNac);


    }

    /**
     * Devuelve el número del historial médico del paciente
     *
     * @return el numHistorial del paciente, como String.
     */
    public String getNumHistorial() {
        return numHistorial;
    }

    /**
     * Cambia el  número del historial médico del paciente
     *
     * @param nH el numHistorial del paciente
     */
    public void setNumHistorial(String nH) {
        numHistorial = nH;
    }

    /**
     * Devuelve la fecha de nacimiento del paciente
     *
     * @return El valor como objeto Fecha
     **/
    public Fecha getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Cambia la fecha de nacimiento del paciente
     *

     */
    public void setFechaNacimiento(Fecha fechaNac) {
        this.fechaNacimiento = fechaNac;
    }

    @Override

    public Element toDOM(){

        Element root = super.toDOM();

        root.setLocalName(tagPaciente);
        Element eltoNumHist = new Element(tagNumHistorial);
        Element eltoFechaNac = getFechaNacimiento().toDOM();

        eltoNumHist.appendChild(getNumHistorial());
        eltoFechaNac.setLocalName(tagFechaNacimiento);

        root.appendChild(eltoNumHist);
        root.appendChild(eltoFechaNac);

        return root;


    }


    public String toString() {
        StringBuilder toret = new StringBuilder();

        toret.append(super.toString());
        toret.append(getNumHistorial()).append(" ; ");
        toret.append(getFechaNacimiento()).append(" ; ");

        return toret.toString();
    }
}

