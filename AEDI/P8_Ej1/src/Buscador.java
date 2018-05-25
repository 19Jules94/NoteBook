import java.lang.reflect.Array;

public class Buscador {
    int enteros[] = new int[1000];

    public int[] llenar() {


        int i = 0;
        int valor = 0;
        while (i < enteros.length) {

            if (valor > 100) {

                valor = 0;
            }
            enteros[i] = valor;


            i++;
            valor++;
        }

        return enteros;
    }


    public int menores30() {

        int i = 0;
        int contador = 0;

        while (i < enteros.length) {

            if(enteros[i] < 30) contador++;
            i++;
        }

        return contador;

    }

    public int mayores70() {

        int i = 0;
        int contador = 0;

        while (i < enteros.length) {

            if(enteros[i] > 70) contador++;
            i++;
        }
        return contador;


    }

    public int menores30Ymayores70() {

        int i = 0;
        int contador = 0;

        while (i < enteros.length) {

            if(enteros[i] >= 30 && enteros[i]<70) contador++;
            i++;
        }

        return contador;

    }

}