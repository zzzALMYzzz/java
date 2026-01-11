package timus.task_1607;

import java.util.Scanner;

public class Main {  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, "cp866");

        int min = in.nextInt();
        int plus = in.nextInt();
        int max = in.nextInt();
        int minus = in.nextInt();
        int result = 0;
        
        while(min < max) {
            min += plus;
            max -= minus;
            if(min > max) result = min;
            else result = max;
        }

        System.out.println(result);

        in.close();
    }  
}
