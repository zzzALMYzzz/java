package lr2;

import java.util.Scanner;

public class example4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, "cp866");

        System.out.println("Введите число: ");
        int iNum = in.nextInt();

        if ((iNum >= 5) && (iNum <= 10)) {
            System.out.println("Число попадает в диапазон от 5 до 10 включительно.");
        } else {
            System.out.println("Число НЕ удовлетворяет условиям.");
        }

        in.close();
    }
}
