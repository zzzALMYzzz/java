package lr9;

import java.util.Scanner;

public class example1_1 {  
    public static void m(int x) {
        System.out.println("x=" + x);
        if ((2 * x + 2) < 30) {
            m(2 * x + 2);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, "cp866");
        System.out.println("Введите число: ");
        int iNum = in.nextInt();
        m(iNum);
        in.close();
    }  
}
