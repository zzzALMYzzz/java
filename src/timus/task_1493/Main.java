package timus.task_1493;

import java.util.Scanner;

public class Main {  
    public static int sum(int a) {
        int sum = 0;
        while (a != 0) {
            sum += a % 10;
            a /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, "cp866");

        int a = in.nextInt();
        
        int apl = a + 1;
        int fpl = apl / 1000;
        int lpl = apl % 1000;
        int amns = a - 1;
        int fmns = amns / 1000;
        int lmns = amns % 1000;
        
        if (sum(fpl) == sum(lpl) || sum(fmns) == sum(lmns))
            System.out.println("Yes");
        else
            System.out.println("No");

        in.close();
    }  
}
