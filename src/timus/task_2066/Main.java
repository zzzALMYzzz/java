package timus.task_2066;

import java.util.Scanner;

public class Main {  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, "cp866");
        int a = in.nextInt();
        if((0 >= a || a >= 101)) {
            System.out.println("Ошибка: число должно быть больше нуля и меньше ста");
            System.exit(1);
        }
        int b = in.nextInt();
        if((0 >= b || b >= 101) && (a > b)) {
            System.out.println("Ошибка: число должно быть больше нуля и меньше ста");
            System.exit(1);
        }
        int c = in.nextInt();
        if((0 >= c || c >= 101) && (b > c)) {
            System.out.println("Ошибка: число должно быть больше нуля и меньше ста");
            System.exit(1);
        }

        int iResult = 0;
        if(b == 0 || b == 1 || c == 1) {
            iResult = a - b - c;
        } else {
            iResult = a - b * c;
        }

        System.out.println("Результат: " + iResult);
        in.close();
    }  
}
