package lr2;

import java.util.Scanner;

public class example5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, "cp866");

        System.out.println("Введите число: ");
        int iNum = in.nextInt();

        int iResult = (iNum / 1000) % 10;

        System.out.println("Цифра в разряде тысяч: " + iResult);

        in.close();
    }
}
