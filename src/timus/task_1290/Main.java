package timus.task_1290;

import java.util.Arrays;
import java.util.Scanner;

public class Main {  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, "cp866");
        String line = in.nextLine();
        
        int n = Integer.parseInt(line.trim());
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(in.nextLine().trim());
        }
        Arrays.sort(array);

        for (int i = n - 1; i >= 0; i--) {
            System.out.println(array[i]);
        }
        in.close();
    }  
}
