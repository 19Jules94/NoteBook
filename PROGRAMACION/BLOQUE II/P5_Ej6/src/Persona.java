public class Persona {

    String dni,nombre;
    int edad;

    public Persona(String dni, String nombre, int edad) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {

        StringBuilder toret = new StringBuilder();

        toret.append("Nombre: ").append(getNombre());
        toret.append("\n");
        toret.append("Dni: ").append(getDni());
        toret.append("\n");
        toret.append("Edad: ").append(getEdad());


        return toret.toString() ;
    }
}
