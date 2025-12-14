package lr4;

import java.util.Scanner;

public class example7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, "cp866");
        
        System.out.print("Введите количество строк прямоугольника: ");
        int iRows = in.nextInt();
        
        System.out.print("Введите количество столбцов прямоугольника: ");
        int iCols = in.nextInt();
        
        int[][] iRectangle = new int[iRows][iCols];
        int iNum = 1;
        
        for (int i = 0; i < iRows; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < iCols; j++) {
                    iRectangle[i][j] = iNum++;
                }
            } else {
                for (int j = iCols - 1; j >= 0; j--) {
                    iRectangle[i][j] = iNum++;
                }
            }
            System.out.println();
        }
        
        System.out.println("Исходный массив:");
        for (int i = 0; i < iRows; i++) {
            for (int j = 0; j < iCols; j++) {
                System.out.print(iRectangle[i][j] + " ");
            }
            System.out.println();
        }

        in.close();
    }
}
