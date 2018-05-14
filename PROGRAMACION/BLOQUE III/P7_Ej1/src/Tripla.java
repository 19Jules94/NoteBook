public class Tripla<T,S,E> {

    //Crea la clase Tripla, que es capaz de albergar exactamente tres valores de cualquier tipo. Crea un código simple de ejemplo que utilice la clase.

private  T a;
private  S b;
private  E c;




    public Tripla(T a, S b, E c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public T getA() {
        return a;
    }

    public S getB() {
        return b;
    }

    public E getC() {
        return c;
    }


    @Override
    public String toString() {

        return String.format( "(%s, %s, %s)",

        getA().toString(),
        getB().toString(),
        getC().toString());

    }
}
