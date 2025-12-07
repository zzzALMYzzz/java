package lr3;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class example9 {
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

        int[] iArray = new int[iSize];
        System.out.print("Массив: ");
        for (int i = 0; i < iSize; i++) {
            iArray[i] = iRandom.nextInt(100) + 1;
            System.out.print(iArray[i] + " ");
        }
        System.out.println();

        int iMin = iArray[0];
        for (int i = 1; i < iSize; i++) {
            if (iArray[i] < iMin) {
                iMin = iArray[i];
            }
        }

        ArrayList<Integer> iIndices = new ArrayList<>();
        for (int i = 0; i < iSize; i++) {
            if (iArray[i] == iMin) {
                iIndices.add(i);
            }
        }

        System.out.println("Минимальное значение: " + iMin);
        System.out.print("Индексы элементов с минимальным значением: ");
        for (int i = 0; i < iIndices.size(); i++) {
            if (i > 0) System.out.print(", ");
            System.out.print(iIndices.get(i));
        }
        System.out.println();

        in.close();
    }
}
