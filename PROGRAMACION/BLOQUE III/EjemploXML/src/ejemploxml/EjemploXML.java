/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemploxml;

/**
 *
 * @author pcuesta
 */
import java.util.*;
import java.lang.*;
import java.io.*;
import nu.xom.*;

public class EjemploXML {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Agenda agenda;
 
        try {
        	agenda = new Agenda( "agenda.xml" );
        	System.out.println( "Arrancando con datos...\n" );
        }
        catch(IOException exc) {
        	agenda = new Agenda();
        	System.out.println( "Archivo no encontrado. arrancando sin datos...\n" );
        }
        catch(ParsingException exc) {
        	agenda = new Agenda();
        	System.out.println( "Archivo con errores, arrancando sin datos...\n" );
        }
 
        if ( agenda.getNum() == 0 ) {
    	    agenda.inserta( new Contacto( "Baltasar", "jbgarcia@uvigo.es", 
                    988111111) );
	    agenda.inserta( new Contacto( "Pedro", "pcuesta@uvigo.es",
                    988222222) );
            agenda.inserta( new Pareja( "Vanesa", "vanesa@uvigo.es", 
                    988111111,new Fecha(10,10,2008)) );
            agenda.inserta( new Instagram( "Pedro", "pcuesta@uvigo.es",
                    988222222,"@pcuesta") );
        }else  {
             agenda.inserta( new Pareja( "Juana", "Juana@uvigo.es", 
                    988111111,new Fecha(10,10,2006)) 
             );
        }
        try {
            System.out.println( agenda );
            System.out.println( "Guardando..." );
            agenda.toXML( "agenda.xml" );
        }
        catch(IOException exc) {
        	agenda = new Agenda();
        	System.out.println( "Archivo no encontrado" );
        }
    }
    
}
