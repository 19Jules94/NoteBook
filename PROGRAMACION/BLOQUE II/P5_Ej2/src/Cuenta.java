
public class Cuenta extends  ProductoFinanciero {

    public enum Tipo { LIBRETA, AHORRO, VIVIENDA };

    Tipo tipoCuenta;



    public Cuenta(double saldo, double interes, Tipo tipoCuenta) {
        super(saldo, interes);
        this.tipoCuenta = tipoCuenta;
    }


    public Tipo getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(Tipo tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public void ingreso (double dineroIngresar){

           saldo += dineroIngresar;

    }

    public void reintegra (double dineroQuitar) throws Exception {

        if(dineroQuitar > getSaldo()){

            System.err.println("El saldo es insuficiente para la cantidad a retirar");

        }else{

            saldo -= dineroQuitar;

        }

    }

    public void aplicaInteres()
    {
        saldo += ( getSaldo() * getInteres() );
    }



    @Override
    public String toString() {
        StringBuilder toret = new StringBuilder();

        toret.append("Cuenta: ");
        toret.append( getTipoCuenta().toString().toLowerCase() );
        toret.append("\n");
        toret.append(super.toString());

        return toret.toString();




    }
}
