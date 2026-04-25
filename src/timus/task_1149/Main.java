package timus.task_1149;

import java.util.Scanner;

public class Main {  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, "cp866");
        int n = in.nextInt();
        System.out.println(buildS(n));
        in.close();
    }

    private static String buildA(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append("sin(").append(i);
            if (i < n) {
                sb.append(i % 2 != 0 ? "-" : "+");
            }
        }
        for (int i = 0; i < n; i++) {
            sb.append(")");
        }
        return sb.toString();
    }

    private static String buildS(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n; i++) {
            sb.append("(");
        }
        for (int i = 1; i <= n; i++) {
            sb.append(buildA(i));
            sb.append("+").append(n - i + 1);
            if (i < n) {
                sb.append(")");
            }
        }
        return sb.toString();
    }
}
