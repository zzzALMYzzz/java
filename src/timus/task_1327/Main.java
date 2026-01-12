package timus.task_1327;

import java.util.Scanner;

public class Main {  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, "cp866");

        int a = in.nextInt();
        int b = in.nextInt();

        int result = ((b - a) >> 1);
        if ((a & 1) > 0 || (b & 1) > 0) {
            result++;
        }

        System.out.println(result);

        in.close();
    }  
}
