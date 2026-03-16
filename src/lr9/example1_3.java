package lr9;

import java.util.Scanner;

public class example1_3 {
    private static int step = 0;
    public static void m(int x) {
        space();
        System.out.println("" + x + "-> ");
        step++;
        if ((2 * x + 2) < 30) {
            m(2 * x + 2);
        }
        step--;
        space();
        System.out.println("" + x + "<- ");
    }

    public static void space() {
        for(int i = 0; i < step; i++) {
            System.out.print(" ");
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
