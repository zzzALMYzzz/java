package timus.task_1068;

import java.util.Scanner;

public class Main {  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, "cp866");

        int n = in.nextInt();

        if(n > 10000 || n < -10000) {
            System.out.print("Ошибка"); 
            System.exit(0);
        }

        if (n >= 1) System.out.print(n *(n + 1) / 2);
        if (n < 1) System.out.print(-((-n) *(1 -n) / 2) + 1);

        in.close();
    }  
}
