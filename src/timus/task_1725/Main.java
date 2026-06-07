package timus.task_1725;

import java.util.Scanner;

public class Main {  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, "cp866");

        if (in.hasNextInt()) {
            int n = in.nextInt();
            int k = in.nextInt();

            if (k == 1 || k == n) {
                System.out.println(0);
            } else {
                int ans = Math.max(k - 2, n - k - 1);
                System.out.println(ans);
            }
        }
        in.close();
    }  
}
