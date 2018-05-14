import lista.*;

public class Hash<E> implements TAD_TablaHash_1<E> {

    Lista tabla[] ;

    public Hash(int n) {
        tabla = new Lista[n];


        for (int i = 0; i<tabla.length;i++){

            tabla[i] = new ListaEnlazada<E>();


        }
    }

    private int funcionHash (E clave){

        return Math.abs(clave.hashCode() % tabla.length);

    }


    @Override
    public boolean insertar(E elem) {

        int index = funcionHash(elem);
        for(E e : tabla[index]){

            if(tabla[index].contiene(elem)){

                tabla[index].suprimir(elem);
                tabla[index].insertarFinal(elem);


            }else{


                return false;
            }


        }


        return false;
    }

    @Override
    public boolean buscar(E elem) {


        return false;
    }


    @Override
    public boolean eliminar(E elem) {
        return false;
    }

    @Override
    public int tamaño() {
        return 0;
    }
}
