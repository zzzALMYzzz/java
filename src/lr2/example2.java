package lr2;

import java.util.Scanner;

public class example2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, "cp866");

        System.out.println("Введите число: ");
        int iNum = in.nextInt();

        if (((iNum % 5) == 2) && ((iNum % 7) == 1)) {
            System.out.println("Число удовлетворяет условиям.");
        } else {
            System.out.println("Число НЕ удовлетворяет условиям.");
        }

        in.close();
    }
}
