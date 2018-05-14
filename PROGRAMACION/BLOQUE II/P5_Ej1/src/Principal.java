public class Principal {


    public static void main(String[] args) {
        Cuenta c = new Cuenta(200,0.5);

        c.ingreso(2200);

        System.out.println(c);

        Prestamo p = new Prestamo(10000,0.10,12);

        p.amortizar();
        p.amortizar();

        System.out.println(p);

    }

}
