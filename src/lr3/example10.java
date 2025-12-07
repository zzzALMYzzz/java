package lr3;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class example10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, "cp866");
        Random iRandom = new Random();

        System.out.print("Введите размер массива: ");
        int iSize = in.nextInt();

        if (iSize <= 0) {
            System.out.println("Размер массива должен быть положительным.");
            in.close();
            return;
        }

        Integer[] iArray = new Integer[iSize];
        System.out.print("Исходный массив: ");
        for (int i = 0; i < iSize; i++) {
            iArray[i] = iRandom.nextInt(100) + 1;
            System.out.print(iArray[i] + " ");
        }
        System.out.println();

        Arrays.sort(iArray, Collections.reverseOrder());

        System.out.print("Массив по убыванию: ");
        for (int iValue : iArray) {
            System.out.print(iValue + " ");
        }

        in.close();
    }
}
