package lr9;

import java.util.Scanner;

public class example1_4 {  
    public static int fact(int x) {
        int result;
        if(x == 1) return 1;
        else {
            result = fact(x - 1) * x;
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
