package lr3;

import java.util.Scanner;

public class example4_for {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, "cp866");

        System.out.println("Введите 1 число: ");
        int iNum_1 = in.nextInt();

        System.out.println("Введите 2 число: ");
        int iNum_2 = in.nextInt();

        int iMin = Math.min(iNum_1, iNum_2);
        int iMax = Math.max(iNum_1, iNum_2);

        System.out.println("Числа в диапазоне от " + iMin + " до " + iMax + ":");
        for (int i = iMin; i <= iMax; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        in.close();
    }
}
