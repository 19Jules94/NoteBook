public class Reunion extends Fecha{



    public Reunion(int hora, int minutos, int segundos, int dia, int mes, int anho) {
        super(hora, minutos, segundos, dia, mes, anho);
    }






    @Override
    public String toString() {

        StringBuilder toret = new StringBuilder();

        toret.append(super.toString());


        return toret.toString();
    }
}
