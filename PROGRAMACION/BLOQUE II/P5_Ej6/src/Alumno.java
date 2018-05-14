public class Alumno extends Persona {





    public Alumno(String dni, String nombre, int edad) {
        super(dni, nombre, edad);

    }




    @Override
    public String toString() {

        StringBuilder toret = new StringBuilder();

        toret.append(super.toString());
        toret.append("\n");

        return toret.toString();
    }
}
