/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemploxml;


import nu.xom.*;

/**
 *
 * @author José María Martínez Penedo
 */
public class Instagram extends Contacto {

    private String usuario;
    public static final String EtqUsuario = "usuario";
    public static final String EtqInstagram = "instagram";

    public Instagram(String nombre, String email, int telefono, String usuario) {
        super(nombre, email, telefono);
        this.usuario = usuario;
    }
    
    /** Crea un nuevo Instagram, desde un Element de XML
    * @param e El objeto Element de XML
    */
    public Instagram(Element e) throws ParsingException {
        super(e);
        Element eltoUsuario = e.getFirstChildElement(EtqUsuario);
        if (eltoUsuario == null) {
            throw new ParsingException("falta el usuario en el elemento");
        }
        this.usuario = eltoUsuario.getValue();
    }
    public String getUsuario() {
        return this.usuario;
    }
    @Override
    public String toString() {
        return super.toString() + String.format("Usuario Instagram: %s\n", this.getUsuario());
    }
    /** Devuelve un objeto Element para generar el DOM
     * @return Un objeto Element.
     */   
    @Override
    public Element toDOM() {
        Element toret = super.toDOM();
        Element eltoUsuario = new Element(EtqUsuario);
        eltoUsuario.appendChild(usuario);
        toret.setLocalName(EtqInstagram);
        toret.appendChild(eltoUsuario);
        return toret;
    }
}
