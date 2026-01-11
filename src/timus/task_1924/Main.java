package timus.task_1924;

import java.util.Scanner;

public class Main {  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, "cp866");

        int n = in.nextInt();
        
        int remainder = n % 4;
        if (remainder == 0 || remainder == 3) {
            System.out.println("black");
        } else {
            System.out.println("grimy");
        }

        in.close();
    }  
}
