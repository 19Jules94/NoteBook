public class Prestamo extends ProductoFinanciero{

    int cuotas;
    double precioCuota;

    public Prestamo(double saldo, double interes, int cuotas) {
        super(saldo, interes);
        this.cuotas = cuotas;

        precioCuota = getSaldo()/cuotas;

    }

    public int getCuotas() {
        return cuotas;
    }

    public double getPrecioCuota() {
        return precioCuota;
    }


    public void amortizar(){


        saldo -= getPrecioCuota();

        --cuotas;
    }

    @Override
    public String toString() {

        StringBuilder toret = new StringBuilder();
        toret.append("Prestamo");
        toret.append("\n");
        toret.append("El precio de cada cuota es de "+getPrecioCuota()+"\n");
        toret.append(super.toString());

        return toret.toString();
    }
}
