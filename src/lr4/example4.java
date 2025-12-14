package lr4;

import java.util.Scanner;

public class example4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, "cp866");

        System.out.print("Введите высоту треугольника: ");
        int iHeight = in.nextInt();

        char[][] iTriangle = new char[iHeight][iHeight];
        
        for (int i = 0; i < iHeight; i++) {
            for (int j = 0; j <= i; j++) {
                iTriangle[i][j] = '*';
            }
        }

        for (char[] i : iTriangle) {
            for (char element : i) {
                if (element != ' ') {
                    System.out.print(element);
                } else {
                    System.out.print(' ');
                }
            }
            System.out.println();
        }

        in.close();
    }
}
