import java.util.ArrayList;
import java.util.List;

public class Multiplos {

    public static List<Integer> multiplos(int n, int m) {

        ArrayList<Integer> l = new ArrayList<>();

        for(int i = 1;i< n; i++){


            if(i%m==0){

                l.add(i);

            }



        }

        return l;


    }




    public static void main(String[] args)
    {

        System.out.println(multiplos(36,6));
    }
}