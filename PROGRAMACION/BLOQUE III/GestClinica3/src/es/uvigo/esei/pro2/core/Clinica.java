/*  Definición de la clase Clinica
 *  En una clínica tendremos una serie de pacientes y médicos
 *  Además, podrá haber citas médicas entre pacientes y médicos
*/

package es.uvigo.esei.pro2.core;

import nu.xom.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author nrufino
 */
public class Clinica {
    public static class ClinicaException extends Exception {        
        public ClinicaException(String msg){
            super(msg);
        }
    }
    
    public static class DemasiadosElementosException extends ClinicaException{
        public DemasiadosElementosException(String msg) {
            super(msg);
        }        
    }
    
    public static class PosicionInexistenteClinicaException 
                        extends ClinicaException{
        public PosicionInexistenteClinicaException(String msg) {
            super(msg);
        }        
    }
    
    public static class ExistenteCitaException extends ClinicaException{
        public ExistenteCitaException(String msg) {
            super(msg);
        }        
    }

    public enum TipoElemento {PACIENTE, MEDICO, CITAMEDICA};
    
    //private Paciente [] pacientes;

    private ArrayList<Paciente> pacientes;
    private int numPacientes;

    //private Medico [] medicos;
    private ArrayList<Medico> medicos;
    private int numMedicos;
    
   //private CitaMedica [] citas;
   private ArrayList<CitaMedica> citas;
    private int numCitas;

    public String TagClinica = "clinica";
    public String TagNombreClinica ="nombre";
    private String nombreClinica;
    
    /** Nueva Clinica con un num. max. de pacientes, de médicos y citas.
     * @param nombre el nombre de la clínica, como cadena.

     */
    public Clinica(String nombre)
    {
        this.nombreClinica = nombre;
        numPacientes = numMedicos = numCitas = 0;
        //pacientes = new Paciente[ maxPacientes  ];
        //medicos = new Medico [ maxMedicos ];
        //citas = new CitaMedica [ maxCitas ];

        pacientes = new ArrayList<>();
        medicos = new ArrayList<>();
        citas = new ArrayList<>();
    }
/*
    public  Clinica(Element e) throws Exception {

        Element eltoNombreClinica = e.getFirstChildElement(TagNombreClinica);

        if(eltoNombreClinica == null){
            throw new Exception("falta el nombre de la clinica en el elemento");

        }
        this.nombreClinica = eltoNombreClinica.getValue();

    }*/
    public  Clinica(String nf) throws ParsingException,IOException {
        Builder parser = new Builder();
        Document doc = parser.build( new File( nf ) );



    }


    /**
     * Devuelve la persona (paciente o medico) situado en pos
     * @param pos el lugar de la persona en el vector correspondiente
     * @param tipo el tipo de persona (paciente o medico)
     * @return el objeto Persona (Paciente o Medico) correspondiente.
     */
    public Persona getPersona(int pos, TipoElemento tipo) 
                              throws PosicionInexistenteClinicaException {
        Persona p = new Medico ("", "", "");

        switch (tipo) {
            case PACIENTE:
                if (pos >= getNumPacientes()) {
                   throw new PosicionInexistenteClinicaException("getPaciente()"
                            + " sobrepasa la pos: " + (pos)
                            + " / " + pacientes.size());
                }
                //p = pacientes[pos];
                p= pacientes.get(pos);
                break;
            case MEDICO:
                if (pos >= getNumMedicos()) {
                    throw new PosicionInexistenteClinicaException("getMedico()"
                            + " sobrepasa la pos: " + (pos)
                            + " / " + medicos.size());
                }

                //p = medicos[pos];
                p=medicos.get(pos);
                break;
        }
        return p;
    }

    /**
     * Devuelve la cita médica situada en pos
     * @param pos el lugar de la cita médica en el vector de citas
     * @return el objeto CitaMedica correspondiente.
     */
    public CitaMedica getCita(int pos)throws PosicionInexistenteClinicaException
    {
        if ( pos >= getNumCitas() ) {
            throw new PosicionInexistenteClinicaException ( "getCita(): "
                    + "sobrepasa la pos: " + ( pos + 1 ) 
                    + " / " + citas.size() );
        }

        //return citas[ pos ];
        return citas.get(pos);
    }    
    
    /** Devuelve el num. de pacientes creados.
     * @return el num. de pacientes existentes, como entero.
     */
    public int getNumPacientes()
    {
        return numPacientes;
    }
    /** Devuelve el num. de medicos creados.
     * @return el num. de medicos existentes, como entero.
     */
    public int getNumMedicos() {
        return numMedicos;
    }
    
    /** Devuelve el num. de citas médicas creadas.
     * @return el num. de citas médicas existentes, como entero.
     */
    public int getNumCitas() {
        return numCitas;
    }

    /** Inserta un nuevo paciente
     * @param c el nuevo objeto Paciente
     */
    public void insertaCita(CitaMedica c)throws DemasiadosElementosException
    {        
        if ( getNumCitas() >1000 ) {
            throw new DemasiadosElementosException ("inserta() sobrepasa max.: "
                  + citas.size() );
        }

       // citas[ numCitas ] = c;
        citas.add(c);
        numCitas++;
    }
    
    public void insertaPersona(Persona p)throws DemasiadosElementosException
    {
        if (p instanceof Paciente){
            if ( getNumPacientes()> 1000 ) {
                throw new DemasiadosElementosException ("inserta() "
                        + "sobrepasa max.: " + pacientes.size() );
            }
            //pacientes[ numPacientes ] = (Paciente) p;

            pacientes.add((Paciente) p);
            numPacientes++;

        } else if (p instanceof Medico){        
            if ( getNumMedicos() >1000) {
                throw new DemasiadosElementosException ("inserta() "
                        + "sobrepasa max.: " + medicos.size() );
            }
            //medicos[ numMedicos ] = (Medico) p;
            medicos.add((Medico) p);
            numMedicos++;
        }
    }

    /** Devuelve el médico con el número de colegiado indicado.
     * @return el médico con el número de colegiado, como Medico.
     */
    public Medico existeMedico(String numCol){
        int i = 0;
        while ((i < getNumMedicos()) &&
            (! (medicos.get(i).getNumColegiado().equals(numCol)))){
                i++;
        }
        if (i == getNumMedicos()){
            return null;
        }
        else return medicos.get(i);
    }
    
    /** Devuelve el paciente con el número de historial indicado.
     * @return el paciente con el número de historial, como Paciente.
     */
    public Paciente existePaciente(String numHis){
        int i = 0;
        while ((i < getNumPacientes()) && 
            (! (pacientes.get(i).getNumHistorial().equals(numHis)))){
                i++;
        }
        if (i == getNumPacientes()){
            return null;
        }
        else return pacientes.get(i);
    }

    /** Elimina la persona (Paciente o Medico) situado en la posicion indicada.
     * @param pos el lugar de la persona en el vector correspondiente
     * @param tipo el tipo de persona (Paciente o Medico) a eliminar
     */
    public void eliminaPersona(int pos, TipoElemento tipo)
            throws PosicionInexistenteClinicaException, ExistenteCitaException {
        switch (tipo) {
            case PACIENTE:
                if (pos >= getNumPacientes()) {
                    throw new PosicionInexistenteClinicaException("elimina"
                            + "Paciente() sobrepasa el numero de pacientes: "
                            + getNumPacientes());
                }
                // Se comprueba que no intervenga en una cita medica para poder 
                // eliminarlo
                if (tienePersonaCita(pacientes.get(pos))) {
                    throw new ExistenteCitaException("eliminaPaciente() "
                            + "no se puede eliminar ese paciente pues tiene "
                            + "citas médicas.");
                }
                //pacientes[pos] = pacientes[--numPacientes];
                pacientes.remove(pos);
                numPacientes--;
                break;
            case MEDICO:
                if (pos >= getNumMedicos()) {
                    throw new PosicionInexistenteClinicaException("elimina"
                            + "Medico() sobrepasa el numero de medicos: "
                            + getNumMedicos());
                }
                // Se comprueba que no intervenga en una cita medica para poder 
                //eliminarlo
                if (tienePersonaCita(medicos.get(pos))) {
                    throw new ExistenteCitaException("eliminaMedico(): no se "
                       + "puede eliminar ese médico pues tiene citas médicas.");
                }
                //medicos[pos] = medicos[--numMedicos];
                medicos.remove(pos);
                numMedicos--;
                break;
        }

    }       
    
    /** Elimina la cita medica situado en la posicion indicada.
     * @param pos el lugar de la cita medica en el vector de citas
     */
    public void eliminaCita(int pos) throws PosicionInexistenteClinicaException
    {        
        if (pos >= getNumCitas()) {
            throw new PosicionInexistenteClinicaException("eliminaCita(): "
                    + "sobrepasa el numero de citas medicas: "
                    + getNumCitas());
        }
        //citas[pos] = citas[ --numCitas];
        citas.remove(pos);
        numCitas--;
    }    

    public String toString(TipoElemento tipo) {
        StringBuilder toret = new StringBuilder();
        
        switch (tipo){
            case PACIENTE : if ( getNumPacientes() > 0 ) {
                                toret.append("Los pacientes de la clinica "
                                        + "son:\n");
                                for (int i = 0; i < numPacientes; i++) {
                                    toret.append( ( i + 1 ) ).append( ". " );                
                                    toret.append(pacientes.get(i).toString())
                                            .append("\n");
                                }
                                } else {
                                    toret.append("No hay pacientes." );
                                }                
                             break;
            case MEDICO : if ( getNumMedicos() > 0 ) {
                                toret.append("Los médicos de la clinica "
                                        + "son: \n");
                                for (int i = 0; i < numMedicos; i++) {
                                    toret.append( ( i + 1 ) ).append( ". " );                
                                    toret.append(medicos.get(i).toString())
                                            .append("\n");
                                }
                                } else {
                                    toret.append("No hay médicos." );
                                }                
                             break;  
            case CITAMEDICA : if ( getNumCitas() > 0 ) {
                                toret.append("Las citas médicas de la clinica "
                                        + "son: \n");
                                for (int i = 0; i < numCitas; i++) {
                                    toret.append( ( i + 1 ) ).append( ". " );                
                                    toret.append(citas.get(i).toString())
                                            .append("\n");
                                }
                                } else {
                                    toret.append("No hay citas médicas." );
                                }                
                             break;                
        }
      
        return toret.toString();        
    }

    public String listarPorTipoPaciente(Paciente.TipoPaciente tipo) 
            throws PosicionInexistenteClinicaException
    {
        final int numPacientes = getNumPacientes();
        StringBuilder toret = new StringBuilder();
        Paciente p;

        if (numPacientes > 0) {
            for (int i = 0; i < numPacientes; i++) {
                p = (Paciente) getPersona(i, Clinica.TipoElemento.PACIENTE);
                switch (tipo) {
                    case PRIVADO:
                        if (p instanceof Privado) {
                            toret.append(p.toString() + "\n");
                        }
                        break;
                    case ASEGURADO:
                        if (p instanceof Asegurado) {
                            toret.append(p.toString() + "\n");
                        }
                        break;
                }
            }
        }
        else {    
            toret.append("No hay pacientes." );
        }
        
        if (toret.length() == 0){
            toret.append("No hay pacientes de ese tipo." );
        }
        
        return toret.toString();
    }
  
    
    /** Devuelve true si la persona (Paciente o Medico) tiene alguna cita médica
     * @param p objeto Persona (Paciente o Medico) a localizar
     * @return boolean si la persona tiene o no alguna cita médica.
     */
    private boolean tienePersonaCita(Persona p) {
        int i = 0;
        
        if ( p instanceof Paciente ){
                while ((i < getNumCitas())
                        && (!(pacientes.get(i).equals(p)))) {
                    i++;
                }
        }
        else if (p instanceof Medico ){
                while ((i < getNumCitas())
                        && (!(medicos.get(i).equals(p)))) {
                    i++;
                }                
        }

        if (i == getNumCitas()) {
            return false;
        } else {
            return true;
        }
    }

    public Element toDOM() {

        Element raiz = new Element ( TagClinica );
        Element eltoNomClinica = new Element ( TagNombreClinica );
        eltoNomClinica.appendChild(nombreClinica);

        raiz.appendChild(eltoNomClinica);

        return  raiz;

    }

    public void toXML(String nf) throws IOException
    {
        FileOutputStream f = new FileOutputStream( nf );
        Serializer serial = new Serializer( f );
        Document doc = new Document( this.toDOM());
        serial.write(doc);
    }
}