package lr3;

import java.util.Scanner;

public class example5_for {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, "cp866");

        System.out.println("Введите количество чисел для суммирования: ");
        int iCount = in.nextInt();

        if (iCount <= 0) {
            System.out.println("Количество должно быть положительным.");
            in.close();
            return;
        }

        int iSum = 0;
        int iFound = 0;
        int iNum = 1;

        System.out.println("Числа, удовлетворяющие условиям: ");

        for (; iFound < iCount; iNum++) {
            if (iNum % 5 == 2 || iNum % 3 == 1) {
                System.out.print(iNum + " ");
                iSum += iNum;
                iFound++;
            }
        }

        System.out.println("\nСумма: " + iSum);

        in.close();
    }
}
