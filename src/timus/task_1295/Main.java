package timus.task_1295;

import java.util.Scanner;

public class Main {  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, "cp866");

        int n = in.nextInt();

        switch (n % 4) {
            case 1:
            case 2:
                System.out.println(1);
                break;
            case 3:
                System.out.println(2);
                break;
            case 0:
                System.out.println(0);
                break;
        }
        
        in.close();
    }  
}
