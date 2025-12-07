package lr3;

import java.util.Scanner;

public class example6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, "cp866");
        int iSize = 0;

        while (true) {
            System.out.print("Введите размер массива: ");
            try {
                iSize = Integer.parseInt(in.nextLine());
                if (iSize < 0) {
                    System.out.println("Размер массива не может быть отрицательным. Попробуйте снова.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите корректное целое число.");
            }
        }

        int[] iArray = new int[iSize];
        for (int i = 0; i < iSize; i++) {
            iArray[i] = 5 * i + 2;
        }

        System.out.print("Заполненный массив: ");
        for (int i = 0; i < iArray.length; i++) {
            System.out.println(iArray[i]);
        }

        in.close();
    }
}
