package timus.task_1409;

import java.util.Scanner;

public class Main {  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, "cp866");

        int a = in.nextInt();
        int b = in.nextInt();

        System.out.print((b - 1) + " " + (a - 1));

        in.close();
    }  
}
