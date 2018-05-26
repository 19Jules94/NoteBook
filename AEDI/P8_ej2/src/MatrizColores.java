

public class MatrizColores {
    int[][] matriz;
    int vFila, vColumna;


    public int getvFila() {
        return vFila;
    }

    public int getvColumna() {
        return vColumna;
    }


    public MatrizColores(int f, int c) {

        this.vFila = f;
        this.vColumna = c;


        matriz = new int[vFila][vColumna];
        for (int i = 0; i < matriz.length; i++) {

            System.out.print("  |  ");

            for (int j = 0; j < matriz.length; j++) {


                matriz[i][j] = (int) (Math.random() * 6) + 1;


                System.out.print(matriz[i][j]);

                if (j != matriz[i].length - 1) System.out.print("\t\t");
            }

            System.out.println("  |  ");
        }

        System.out.println();
    }


    public void rellenar(int fila, int columna, int color) {
        //2,3,8//

        int numOriginal = matriz[fila][columna];
        int num = 0;

        //Necesitamos 4 bucles para recorrer

        int f = fila ;
        int c = columna+1;

        while (c < vFila && matriz[c][f] == numOriginal) {

                matriz[c][f] = color;

                c++;

        }

        c=columna-1;

        while (c > 0 && matriz[c][f] == numOriginal) {

            matriz[c][f] = color;

            c--;

        }

        c=columna;
        f=fila+1;
        while (f < vColumna && matriz[c][f] == numOriginal) {

            matriz[c][f] = color;

            f++;

        }

        f = fila-1;


        while (f > 0 && matriz[c][f] == numOriginal) {

            matriz[c][f] = color;

            f--;

        }

        matriz[columna][fila] = color;


        for (int i = 0; i < matriz.length; i++) {

            System.out.print("  |  ");

            for (int j = 0; j < matriz.length; j++) {

                System.out.print(matriz[i][j]);

                if (j != matriz[i].length - 1) System.out.print("\t\t");
            }

            System.out.println("  |  ");
        }


    }
}



