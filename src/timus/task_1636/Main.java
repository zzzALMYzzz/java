package timus.task_1636;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        if (!in.hasNextInt()) return;
        int t1 = in.nextInt();
        int t2 = in.nextInt();

        int totalPenaltyFromAttempts = 0;
        for (int i = 0; i < 10; i++) {
            int attempts = in.nextInt();
            totalPenaltyFromAttempts += attempts * 20;
        }

        int zzzCleanTime = t2 - totalPenaltyFromAttempts;
        if (zzzCleanTime < t1) {
            System.out.println("Dirty debug :(");
        } else {
            System.out.println("No chance.");
        }
        
        in.close();
    }
}
