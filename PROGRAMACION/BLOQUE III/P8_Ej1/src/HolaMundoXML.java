
import nu.xom.*;

import java.io.FileOutputStream;
import java.io.IOException;

public class HolaMundoXML {

    public static void main(String[] args) {

        // Crear los elementos
        Element raiz = new Element( "mensajes" );
        Element mensaje = new Element( "mensaje" );

        // Crear el documento
        mensaje.appendChild( "Hola, mundo" );
        raiz.appendChild( mensaje );
        Document doc = new Document( raiz );

        // Guardarlo
        try {
            FileOutputStream f = new FileOutputStream( "mensaje.xml" );
            Serializer serial = new Serializer( f );
            serial.write( doc );
            f.close();
            System.out.println( "Ok" );
        } catch(IOException exc)
        {
            System.err.println( "ERROR de archivo: " + exc.getMessage() );
        }
    }

}



