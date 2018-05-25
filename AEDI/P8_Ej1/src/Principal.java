public class Principal {

    public static void main(String[] args) {
        Buscador b = new Buscador();

        b.llenar();

        System.out.println("Hay "+b.menores30() +" numero menores que 30" );
        System.out.println("Hay "+b.mayores70() +" numero mayores que 70" );
        System.out.println("Hay "+b.menores30Ymayores70() +" numero mayores que 30 y menores que 70" );


    }
}
