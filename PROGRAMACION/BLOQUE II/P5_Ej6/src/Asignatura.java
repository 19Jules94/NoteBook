public class Asignatura {

    String nombre;
    String cuatrimetre;
    int creditos;

    public Asignatura(String nombre, String cuatrimetre, int creditos) {
        this.nombre = nombre;
        this.cuatrimetre = cuatrimetre;
        this.creditos = creditos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCuatrimetre() {
        return cuatrimetre;
    }

    public void setCuatrimetre(String cuatrimetre) {
        this.cuatrimetre = cuatrimetre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    @Override
    public String toString() {

        StringBuilder toret = new StringBuilder();

        toret.append("Asignatura: ").append(getNombre());
        toret.append("\n");
        toret.append("Cuatrimestre: ").append(getCuatrimetre());
        toret.append("\n");
        toret.append("Creditos: ").append(getCuatrimetre());

        return toret.toString();
    }
}
