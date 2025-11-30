package timus.task_1293;

import java.util.Scanner;

public class Main {  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, "cp866");
        int N = in.nextInt();
        if(0 >= N || N >= 101) {
            System.out.println("Ошибка: число должно быть больше нуля и меньше ста");
            System.exit(1);
        }
        int A = in.nextInt();
        if(0 >= A || A >= 101) {
            System.out.println("Ошибка: число должно быть больше нуля и меньше ста");
            System.exit(1);
        }
        int B = in.nextInt();
        if(0 >= B || B >= 101) {
            System.out.println("Ошибка: число должно быть больше нуля и меньше ста");
            System.exit(1);
        }
        int iResult = N * A * B * 2;
        System.out.println("Результат: " + iResult);
        in.close();
    }  
}