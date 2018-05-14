public class Fecha extends Hora {
    int dia,mes,anho;

    public Fecha(int hora, int minutos, int segundos, int dia, int mes, int anho) {
        super(hora, minutos, segundos);
        this.dia = dia;
        this.mes = mes;
        this.anho = anho;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnho() {
        return anho;
    }

    public void setAnho(int anho) {
        this.anho = anho;
    }

    @Override
    public String toString() {

        StringBuilder toret = new StringBuilder();

        toret.append(super.toString()).append(getDia()).append('/').append(getMes()).append('/').append(getAnho());
        return toret.toString();
    }
}
