package timus.task_1787;

import java.util.Scanner;

public class Main {  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, "cp866");

        int k = in.nextInt();
        int n = in.nextInt();

        int cars[] = new int[n];
        for (int i = 0; i < n; i++) {
            cars[i] = in.nextInt();
        }

        int cur = 0;
        for (int i = 0; i < n; i++) {
            cur += cars[i];
            if ((cur - k) < 0) {
                cur = 0;
            } else {
                cur -= k;
            }
        }

        System.out.println(cur);

        in.close();
    }  
}
