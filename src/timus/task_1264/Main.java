package timus.task_1264;

import java.util.Scanner;

public class Main {  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, "cp866");
        
        int N = in.nextInt();
        if(0 >= N || N >= 40001) {
            System.out.println("Ошибка: число должно быть больше нуля и меньше 40000");
            System.exit(1);
        }

        int M = in.nextInt();
        if(0 >= M || M >= 40001) {
            System.out.println("Ошибка: число должно быть больше нуля и меньше 40000");
            System.exit(1);
        }
        
        long iResult = (long) N * (M + 1);

        System.out.println("Результат: " + iResult);
        in.close();
    }  
}
