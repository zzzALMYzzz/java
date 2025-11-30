package timus.task_1263;

import java.util.Scanner;

public class Main {  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, "cp866");
        
        int N = in.nextInt();
        if(0 >= N || N >= 10001) {
            System.out.println("Ошибка: число должно быть больше нуля и меньше 10000");
            System.exit(1);
        }

        int M = in.nextInt();
        if(0 >= M || M >= 10001) {
            System.out.println("Ошибка: число должно быть больше нуля и меньше 10000");
            System.exit(1);
        }
        
        int[] iVotes = new int[N + 1];
        
        for (int i = 0; i < M; i++) {
            int iCandidate = in.nextInt();
            iVotes[iCandidate]++;
        }
        
        for (int i = 1; i <= N; i++) {
            double iPercentage = (double) iVotes[i] / M * 100;
            System.out.printf("%.2f%%\n", iPercentage);
        }

        in.close();
    }  
}
