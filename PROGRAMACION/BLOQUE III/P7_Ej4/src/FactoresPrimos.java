import java.util.ArrayList;
import java.util.List;

public class FactoresPrimos {

    public static List<Integer> factoresPrimos(int x) {

        ArrayList <Integer> l = new ArrayList<>();
        int divisor =2;

        while(x!=1){
            if(x%divisor==0){

                l.add(divisor);

                x=x/divisor;
            }else{

                divisor=divisor+1;

            }

        }


             return l;

    }



    public static void main(String[] args)
    {
        System.out.println( factoresPrimos( 18 ) );
    }


}
