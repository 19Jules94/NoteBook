public class Cuenta extends  ProductoFinanciero {

    public Cuenta(double saldo, double interes) {
        super(saldo, interes);
    }



    public void ingreso (double dineroIngresar){

           saldo += dineroIngresar;

    }

    public void reintegro (double dineroQuitar) throws Exception {

        if(dineroQuitar > getSaldo()){

            throw  new Exception("ERROR : No puedes quitar mas dinero del que tienes");

        }else{

            saldo -= dineroQuitar;

        }

    }


    @Override
    public String toString() {
        StringBuilder toret = new StringBuilder();

        toret.append("Cuenta: ");
        toret.append("\n");
        toret.append(super.toString());

        return toret.toString();




    }
}
