public class Principal {


    public static void main(String[] args) {

    Asignatura as = new Asignatura("Programacion","Segundo",6);

    Profesor p = new Profesor("35874654P","Pedro",45,301,as);

        System.out.println(p);
    }
}
