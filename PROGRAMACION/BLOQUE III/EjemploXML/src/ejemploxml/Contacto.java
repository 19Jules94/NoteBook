
package ejemploxml;
import nu.xom.*; 
/**
 *
 * @author pcuesta
 */

/** Representa a los contactos en la agenda */
public class Contacto {
    public static final String EtqContacto = "contacto";
    public static final String EtqNombre = "nombre";
    public static final String EtqEmail = "email";
    public static final String EtqTelefono = "telefono";
 
    private String nombre;
    private String email;
    private int telefono;
 
    /** Crea contacto 
     * @param nombre, como String
     * @param email, como String
     * @param telefono, como int
     */
    public Contacto(String nombre, String email, int telefono){
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono; 
    }
 
   /** Crea un nuevo Contacto, desde un Element de XML
    * @param e El objeto Element de XML
    */
    public Contacto(Element e) throws ParsingException {
        Element eltoNombre = e.getFirstChildElement( EtqNombre);
        Element eltoEmail = e.getFirstChildElement( EtqEmail);
        Element eltoTelefono = e.getFirstChildElement( EtqTelefono);
        
        if ( eltoNombre == null ) {
            throw new ParsingException( "Falta el nombre en el elemento contacto" );
        }
        if ( eltoEmail == null ) {
            throw new ParsingException( "Falta el email en el elemento contacto" );
        }
        if ( eltoTelefono == null ) {
            throw new ParsingException( "Falta el teléfono en el elemento contacto" );
        }
 
        this.nombre = eltoNombre.getValue().trim();
        this.email = eltoEmail.getValue().trim();
        try{
                this.telefono = Integer.parseInt(eltoTelefono.getValue().trim());
        }catch(NumberFormatException exc)
        {
                throw new ParsingException("Valor incorrecto para el teléfono");
        }
    }


    public String getNombre() {
        return nombre;
    }    
    public String getEmail() {
        return email;
    }
     public int getTelefono() {
        return telefono;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
       public void setEmail(String email) {
        this.email = email;
    }  
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
    public String toString(){
        return String.format("Nombre: %s"
                + "\nEmail: %s\n"
                + "Teléfono: %10d\n",
                getNombre(), getEmail(), getTelefono());
    }
 
    /** Devuelve un objeto Element para generar el DOM
     * @return Un objeto Element.
     */    
    public Element toDOM(){
        Element raiz = new Element ( EtqContacto );
        Element eltoNombre = new Element ( EtqNombre );
        Element eltoEmail = new Element( EtqEmail );
        Element eltoTelefono = new Element ( EtqTelefono );
 
        eltoNombre.appendChild(nombre);
        eltoEmail.appendChild(email);
        eltoTelefono.appendChild(Integer.toString(telefono));
 
        raiz.appendChild(eltoNombre);
        raiz.appendChild(eltoEmail);
        raiz.appendChild(eltoTelefono);
 
        return raiz;
    }
}
 
