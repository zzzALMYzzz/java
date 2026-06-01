package timus.task_1283;

import java.util.Scanner;

public class Main {  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, "cp866");

        if (in.hasNextDouble()) {
            double currentGold = in.nextDouble();
            double thresholdGold = in.nextDouble();
            double commission = in.nextDouble();
            int years = 0;

            while (currentGold > thresholdGold) {
                currentGold -= currentGold * (commission / 100.0);
                years++;
            }

            System.out.println(years);
        }

        in.close();
    }  
}
