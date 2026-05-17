package timus.task_1935;

import java.util.Scanner;

public class Main {  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, "cp866");
        int n = in.nextInt();
        
        int[] a = new int[n];
        int sum = 0;
        int max = 0;
        
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            sum += a[i];
            if (a[i] > max) {
                max = a[i];
            }
        }
        
        int result = sum + max;
        System.out.println(result);
        in.close();
    }  
}
