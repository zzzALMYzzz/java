package lr3;

import java.util.Scanner;

public class example3_for {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, "cp866");

        System.out.println("Введите число: ");
        int iNum = in.nextInt();

        if (iNum <= 0) {
            System.out.println("Количество должно быть положительным.");
        } else if (iNum == 1) {
            System.out.print("1");
        } else {
            int iFirst = 1, iSecond = 1;
            System.out.print(iFirst + " " + iSecond);

            for (int i = 3; i <= iNum; i++) {
                int next = iFirst + iSecond;
                System.out.print(" " + next);
                iFirst = iSecond;
                iSecond = next;
            }
        }
        System.out.println();

        in.close();
    }
}
