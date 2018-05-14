import java.util.ArrayList;
import java.util.List;

public class Fibonacci {
    public static List<Integer> fibo(int n) {

        ArrayList<Integer> l = new ArrayList<>();


        int n1 =1;
        int n2 = 1;
        int result = 0;

        for (int i = 0; i <n ; i++) {

            l.add(result);

            n2=n1+result;

            n1 = result;

            result = n2;

        }
return  l;
    }

    public static void main(String[] args) {

        System.out.println(fibo(0));


    }

}