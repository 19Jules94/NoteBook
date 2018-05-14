public class Empleado {

    String dni;
    String nombre;
    double salario;

    Cuenta cuenta ;

    public Empleado(String dni,String nombre, double salario,Cuenta cuenta ) {
        this.dni = dni;
        this.nombre = nombre;
        this.salario = salario;
        this.cuenta = cuenta;
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

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }


    public void ingresaSalario (){


        cuenta.ingreso(getSalario());


    }

    @Override
    public String toString() {
        StringBuilder toret = new StringBuilder();

        toret.append("DNI ");
        toret.append(getDni()).append(" ");
        toret.append("Nombre ");
        toret.append(getNombre()).append(" ");
        toret.append(getCuenta());

        return toret.toString() ;
    }
}
