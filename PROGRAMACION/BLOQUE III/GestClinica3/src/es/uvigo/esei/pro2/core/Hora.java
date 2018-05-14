/*
 * Definicion de la clase Hora
 */

package es.uvigo.esei.pro2.core;

import nu.xom.Element;
import nu.xom.ParsingException;

/**
 * @author Nani
 */
public class Hora {
    public static final String tagHora = "hora";
    public static final String tagMinutos = "minutos";

    private int hora;
    private int minutos;

    /**
     * Crea una nueva hora, con sus datos: hora y minutos
     *
     * @param hora    hora
     * @param minutos minutos
     */
    public Hora(int hora, int minutos) {
        this.hora = hora;
        this.minutos = minutos;
    }

    public Hora(Element e) throws ParsingException {

        Element eltoHora = e.getFirstChildElement(tagHora);
        Element eltoMinutos = e.getFirstChildElement(tagMinutos);

        if (eltoHora == null) {

            throw new ParsingException("Falta la hora");

        }

        if (eltoMinutos == null) {

            throw new ParsingException("Faltan los minutos");
        }


        try {

            this.hora = Integer.parseInt(eltoHora.getValue().trim());
        } catch (NumberFormatException exc) {

            throw new ParsingException("Valor para la hora incorrecto");

        }

        try {
            this.minutos = Integer.parseInt(eltoMinutos.getValue().trim());
        } catch (NumberFormatException exc) {

            throw new ParsingException("Valor para los minutos incorrecto");

        }


    }

    /**
     * Devuelve la hora
     *
     * @return la hora, como int.
     */
    public int getHora() {
        return hora;
    }

    /**
     * Devuelve los minutosss
     *
     * @return los minutos, como int.
     */
    public int getMinutos() {
        return minutos;
    }

    /**
     * Cambia la hora
     *
     * @param hora la hora
     */
    public void setHora(int hora) {
        this.hora = hora;
    }

    /**
     * Cambia los minutos
     *
     * @param minutos los minutos
     */
    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

     public Element toDOM(){

        Element root = new Element(tagHora);
        Element eltoHora = new Element(tagHora);
        Element eltoMinutos = new Element(tagMinutos);

        eltoHora.appendChild(Integer.toString(getHora()));
        eltoMinutos.appendChild(Integer.toString(getMinutos()));

        root.appendChild(eltoHora);
        root.appendChild(eltoMinutos);

        return root;



        }

    @Override
    public String toString() {
        StringBuilder toret = new StringBuilder();

        toret.append("(").append(getHora())
                .append(":").append(getMinutos())
                .append(")");

        return toret.toString();
    }

}
