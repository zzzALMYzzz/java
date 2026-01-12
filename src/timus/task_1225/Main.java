package timus.task_1225;

import java.util.Scanner;

public class Main {  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, "cp866");

        int n = in.nextInt();

        if(n <= 2) {
            System.out.println(2);
            System.exit(0);
        }

        long[] a = new long[n];
        a[0] = 2;
        a[1] = 2;
        a[2] = 4;

        for (int i = 2; i < n; i++) {
            a[i] = a[i-1] + a[i-2];
        }
        
        System.out.println(a[n-1]);

        in.close();
    }  
}
