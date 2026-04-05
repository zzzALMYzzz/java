package timus.task_1893;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        if (!in.hasNext()) return;
        
        String input = in.next();
        int row = Integer.parseInt(input.substring(0, input.length() - 1));
        char seat = input.charAt(input.length() - 1);

        if (row >= 1 && row <= 2) {
            if (seat == 'A' || seat == 'D') {
                System.out.println("window");
            } else {
                System.out.println("aisle");
            }
        } else if (row >= 3 && row <= 20) {
            if (seat == 'A' || seat == 'F') {
                System.out.println("window");
            } else if (seat == 'B' || seat == 'C' || seat == 'D' || seat == 'E') {
                System.out.println("aisle");
            } else {
                System.out.println("neither");
            }
        } else {
            if (seat == 'A' || seat == 'K') {
                System.out.println("window");
            } else if (seat == 'C' || seat == 'D' || seat == 'G' || seat == 'H') {
                System.out.println("aisle");
            } else {
                System.out.println("neither");
            }
        }
        
        in.close();
    }
}
