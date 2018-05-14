/*
 * Proyecto de Programación II.
 * Gestión de una clínica. 
 */
package es.uvigo.esei.pro2.ui;

import nu.xom.ParsingException;

import java.io.IOException;

/**
 *
 * @author nrufino
 */

public class Main {
    public static void main(String[] args) throws IOException, ParsingException {
        new Ilc().ler();
    }
}