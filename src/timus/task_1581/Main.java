package timus.task_1581;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, "cp866");

        int n = in.nextInt();
        int numbers[] = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = in.nextInt();
        }

        LinkedList<Integer> convertedList = new LinkedList<Integer>();
        int counter = 1;
        int current = numbers[0];
        for (int i = 1; i < n; i++) {
            if (current == numbers[i]) {
                counter++;
            } else {
                convertedList.addLast(counter);
                convertedList.addLast(current);
                counter = 1;
            }
            current = numbers[i];
        }

        convertedList.addLast(counter);
        convertedList.addLast(current);

        for (Integer value : convertedList) {
            System.out.print(value + " ");
        }
        System.out.println();

        in.close();
    }  
}
