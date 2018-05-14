public class CuentaComisionReintegro extends Cuenta {

    public CuentaComisionReintegro(double saldo, double interes, Tipo tipoCuenta) {
        super(saldo, interes, tipoCuenta);
    }

    private final static double COMISION = 0.5;


    public void reintegra(double v) throws Exception {

      super.reintegra(v+(v*COMISION));


        }


        }
