package lr9;

import java.util.Scanner;

public class example1_5 {  
    public static int fact(int x) {
        System.out.println("Вызов fact(" + x + ")");
        if(x == 0 || x == 1) {
            System.out.println("fact(" + x + ") = " + x);
            return x;
        } else {
            int result = fact(x - 2) + fact(x - 1);
            System.out.println("fact(" + x + ") = " + result);
            return result;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, "cp866");
        System.out.println("Введите число: ");
        int iNum = in.nextInt();
        System.out.println(fact(iNum));
        in.close();
    }  
}
