package timus.task_2023;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        long k = in.nextLong();

        if (n == 1) {
            System.out.println(1);
            System.exit(0);
        }

        int period = 2 * n - 2;

        k = (k - 1) % period + 1;

        if (k <= n) {
            System.out.println(k);
        } else {
            System.out.println(2 * n - k);
        }

        in.close();
    }
}
