package timus.task_1224;

import java.util.Scanner;

public class Main {  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, "cp866");
        int n = in.nextInt();
        int m = in.nextInt();
        int result;
        
        if (n <= m) {
            result = 2 * (n - 1);
        } else {
            result = 2 * (m - 1) + 1;
        }
        
        System.out.println(result);
        in.close();
    }
}
