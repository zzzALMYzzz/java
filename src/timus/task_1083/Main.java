package timus.task_1083;

import java.util.Scanner;

public class Main {  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, "cp866");
        int n = in.nextInt();
        String kMarks = in.next();
        int k = kMarks.length();
        long result = 1;
        
        while (n > 0) {
            result *= n;
            n -= k;
        }
        
        System.out.println(result);
        in.close();
    }  
}
