public class Hora{

int hora,minutos,segundos;


        public Hora(int hora,int minutos, int segundos) {
            this.hora = hora;
            this.minutos = minutos;
            this.segundos = segundos;
        }


        public int getMinutos() {
            return minutos;
        }

        public void setMinutos(int minutos) {
            this.minutos = minutos;
        }

        public int getSegundos() {
            return segundos;
        }

        public void setSegundos(int segundos) {
            this.segundos = segundos;
        }

        public int getHora() {
            return hora;
        }

        public void setHora(int hora) {
            this.hora = hora;
        }

    @Override
    public String toString() {

            StringBuilder toret = new StringBuilder();

            toret.append(getHora()).append(':').append(getMinutos()).append(':').append(getSegundos());
        return toret.toString();
    }
}
