public class Principal {


    public static void main(String[] args) throws Exception {

        //Cuenta c = new CuentaComisionReintegro(00,0.5,Cuenta.Tipo.AHORRO);
        Prestamo p = new Prestamo(10000,0.10,12);

        Empleado e = new Empleado("35577002G","Julio",6248,new CuentaComisionReintegro(00,0.5,Cuenta.Tipo.AHORRO));


        /*****************************************/
        /*
        c.ingreso(2200);
        c.aplicaInteres();
        c.reintegra(200);
        System.out.println(c);

        /*****************************************/
        /*
        p.amortizar();
        p.amortizar();
        System.out.println(p);

        /****************************************/

        e.ingresaSalario();

        System.out.println(e);

    }

}
