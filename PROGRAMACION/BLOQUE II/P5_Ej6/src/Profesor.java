public class Profesor extends Persona {

    int numDespacho;
    Asignatura asignatura;

    public Profesor(String dni, String nombre, int edad, int numDespacho,Asignatura asignatura) {
        super(dni, nombre, edad);
        this.asignatura = asignatura;
        this.numDespacho = numDespacho;

    }

    public int getNumDespacho() {
        return numDespacho;
    }

    public void setNumDespacho(int numDespacho) {
        this.numDespacho = numDespacho;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    @Override
    public String toString() {

        StringBuilder toret = new StringBuilder();

        toret.append(super.toString());
        toret.append("\n");
        toret.append(getNumDespacho());
        toret.append("\n");
        toret.append(getAsignatura());

        return toret.toString();

    }
}
