package lr1;

import java.util.Scanner;

public class example14 {  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, "cp866");

        System.out.println("Введите число: ");
        int num_1 = in.nextInt();
        int num_0 = num_1 - 1;
        int num_2 = num_1 + 1;
        double num_3 = Math.pow((num_0 + num_1 + num_2), 2);

        System.out.println("1 число: " + num_0);
        System.out.println("2 число: " + num_1);
        System.out.println("3 число: " + num_2);
        System.out.println("4 число: " + num_3);
        in.close();
    }  
}