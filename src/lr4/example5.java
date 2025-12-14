package lr4;

import java.util.Scanner;

public class example5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, "cp866");
        
        System.out.print("Введите количество строк прямоугольника: ");
        int iRows = in.nextInt();
        
        System.out.print("Введите количество столбцов прямоугольника: ");
        int iCols = in.nextInt();
        
        int[][] iRectangle = new int[iRows][iCols];
        
        for (int i = 0; i < iRows; i++) {
            for (int j = 0; j < iCols; j++) {
                iRectangle[i][j] = (int) (Math.random() * 100);
            }
        }
        
        System.out.println("Исходный массив:");
        for (int i = 0; i < iRows; i++) {
            for (int j = 0; j < iCols; j++) {
                System.out.print(iRectangle[i][j] + " ");
            }
            System.out.println();
        }

        int[][] iTransposed = new int[iCols][iRows];
        for (int i = 0; i < iRows; i++) {
            for (int j = 0; j < iCols; j++) {
                iTransposed[j][i] = iRectangle[i][j];
            }
        }

        System.out.println("Итоговый массив:");
        for (int i = 0; i < iCols; i++) {
            for (int j = 0; j < iRows; j++) {
                System.out.print(iTransposed[i][j] + " ");
            }
            System.out.println();
        }

        in.close();
    }
}
