package timus.task_1820;

import java.util.Scanner;

public class Main {  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, "cp866");

        int n = in.nextInt();
        int k = in.nextInt();
        int time = 1;

        if (n <= 0) {
            System.out.println(0);
        } else if (n < k) {
            System.out.println(time*2);
        } else {
            int appender = 0;
            int n2 = n << 1;
            if (((n2 % k)) > 0) {
                appender = 1;
            }
            System.out.println(n2 / k + appender);
        }

        in.close();
    }  
}
