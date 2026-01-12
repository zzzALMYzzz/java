package timus.task_2056;

import java.util.Scanner;

public class Main {  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, "cp866");

        int n = in.nextInt();
        int[] vec = new int[n];
        int Kol3 = 0, Kol4 = 0, Kol5 = 0, v;
        float Sum = 0;

        for (int i = 0; i < n; i++) {
            vec[i] = in.nextInt();
            v = vec[i];
            Sum += v;
            if (v == 3) {
                Kol3++;
            } else if (v == 4) {
                Kol4++;
            } else if (v == 5) {
                Kol5++;
            }
        }

        if (Kol3 > 0) {
            System.out.println("None");
        } else if (Kol5 == n) {
            System.out.println("Named");
        } else if (Sum / n >= 4.5) {
            System.out.println("High");
        } else {
            System.out.println("Common");
        }

        in.close();
    }  
}
