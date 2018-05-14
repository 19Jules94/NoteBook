public class ProductoFinanciero {

 double saldo;
 double interes;

    public ProductoFinanciero(double saldo, double interes) {
        this.saldo = saldo;
        this.interes = interes;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getInteres() {
        return interes;
    }

    @Override
    public String toString() {




        return String.format("Saldo:  %.2f(interes: %.2f )",getSaldo(),getInteres()) ;
    }
}
