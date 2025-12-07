package timus.task_1209;

import java.util.Scanner;

public class Main {  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, "cp866");
        long N = in.nextLong();

        if((1 >= N || N >= 65536)) {
            System.out.println("Ошибка: число должно быть больше нуля и меньше ста");
            System.exit(1);
        }
        
        for (long i = 1; i <= N; i++) {
            long x = in.nextLong() - 1;

            long y = (long) Math.sqrt(8 * x + 1);

            if ((y * y) == (8 * x + 1)) {
                System.out.println("1 ");
            } else {
                System.out.println("0 ");
            }
        }

        in.close();
    }  
}
