/*
 * Definicion de la clase Persona
 */

package es.uvigo.esei.pro2.core;

import nu.xom.Element;
import nu.xom.ParsingException;

/**
 * @author Nani
 */
abstract public class Persona {
    private String nombre;  // Nombre completo de la persona
    private String domicilio;

    public static final String tagPersona = "persona";
    public static final String tagNombre = "nombre";
    public static final String tagDomicilio = "domicilio";

    /**
     * Crea una nueva persona, con sus datos: nombre y domicilio
     *
     * @param nombre    nombre completo de la persona
     * @param domicilio el domicilio de la persona
     */
    public Persona(String nombre, String domicilio) {
        this.setNombre(nombre);
        this.setDomicilio(domicilio);
    }

    public Persona(Element e) throws ParsingException {

        Element eltoNombre = e.getFirstChildElement(tagNombre);
        Element eltoDomicilio = e.getFirstChildElement(tagDomicilio);

        if (eltoNombre == null) {
            throw new ParsingException("Falta el nombre en el elemento contacto");
        }
        if (eltoDomicilio == null) {
            throw new ParsingException("Falta el domicilio en el elemento contacto");
        }

        this.nombre = eltoNombre.getValue().trim();
        this.domicilio = eltoDomicilio.getValue().trim();


    }

    /**
     * Devuelve el nombre de la persona
     *
     * @return El valor como cadena
     **/
    public String getNombre() {
        return nombre;
    }

    /**
     * Cambia el nombre de la persona
     *
     * @param nombre El nuevo valor, como cadena
     */
    public void setNombre(String nombre) {
        this.nombre = nombre.trim();
    }

    /**
     * Devuelve el domicilio de la persona
     *
     * @return El valor como cadena
     **/
    public String getDomicilio() {
        return domicilio;
    }

    /**
     * Cambia el domicilio de la persona
     *
     * @param domicilio El nuevo valor, como cadena
     */
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio.trim();
    }

    @Override
    public String toString() {
        StringBuilder toret = new StringBuilder();

        toret.append(getNombre()).append(" ; ");
        toret.append(getDomicilio()).append(" ; ");

        return toret.toString();
    }

    public Element toDOM() {

        Element root = new Element(tagPersona);
        Element eltoNombre = new Element(tagNombre);
        Element eltoDomicilio = new Element(tagDomicilio);

        eltoNombre.appendChild(getNombre());
        eltoDomicilio.appendChild(getDomicilio());

        root.appendChild(eltoNombre);
        root.appendChild(eltoDomicilio);

        return root;


    }
}
