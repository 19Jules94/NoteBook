public class ReunionPeriodica extends Reunion {

    private String frecuencia;


    public ReunionPeriodica(int hora, int minutos, int segundos, int dia, int mes, int anho, String frecuencia) {
        super(hora, minutos, segundos, dia, mes, anho);
        this.frecuencia = frecuencia;
    }


    public String getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(String frecuencia) {
        this.frecuencia = frecuencia;
    }

    @Override
    public String toString() {

        StringBuilder toret = new StringBuilder();

        toret.append(super.toString()).append(" "+getFrecuencia());


        return toret.toString();



    }
}
