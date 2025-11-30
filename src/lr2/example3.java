package lr2;

import java.util.Scanner;

public class example3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, "cp866");

        System.out.println("Введите число: ");
        int iNum = in.nextInt();

        if (((iNum % 4) == 0) && (iNum >= 10)) {
            System.out.println("Число удовлетворяет критериям: делится на 4 и не меньше 10.");
        } else {
            System.out.println("Число НЕ удовлетворяет условиям.");
        }

        in.close();
    }
}
