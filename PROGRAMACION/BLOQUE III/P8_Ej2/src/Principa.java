import nu.xom.*;

import java.io.FileOutputStream;
import java.io.IOException;

public class Principa {

    public static void main(String[] args) {

    //Crear los elementos

        Element raiz = new Element("biblioteca");
        Element libro = new Element("libro");
        Element titulo = new Element("titulo");
        Element autor = new Element("autor");

        Element libro1 = new Element("libro");
        Element titulo1 = new Element("titulo");
        Element autor1 = new Element("autor");

        Element libro2 = new Element("libro");
        Element titulo2 = new Element("titulo");
        Element autor2 = new Element("autor");




    //Crear documento

        libro.appendChild("La historia interminable");
        autor.appendChild("Michael Ende");

        raiz.appendChild(libro);
        raiz.appendChild(autor);

        libro1.appendChild("Don Quijote");
        autor1.appendChild("Miguel de Cervantes Saavedra ");

        raiz.appendChild(libro1);
        raiz.appendChild(autor1);

        libro2.appendChild("El arte de la guerra");
        autor2.appendChild("Sun Tzu");

        raiz.appendChild(libro2);
        raiz.appendChild(autor2);

        Document doc = new Document( raiz );

        try {
            FileOutputStream f = new FileOutputStream( "biblioteca.xml" );
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





