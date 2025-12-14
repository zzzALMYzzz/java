package lr4;

import java.util.Scanner;
import java.util.Random;

public class example6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, "cp866");
        Random rand = new Random();
        
        System.out.print("Введите количество строк прямоугольника: ");
        int iRows = in.nextInt();
        
        System.out.print("Введите количество столбцов прямоугольника: ");
        int iCols = in.nextInt();
        
        int[][] iRectangle = new int[iRows][iCols];
        
        System.out.println("Исходный массив:");
        for (int i = 0; i < iRows; i++) {
            for (int j = 0; j < iCols; j++) {
                iRectangle[i][j] = rand.nextInt(99) + 1;
                System.out.print(iRectangle[i][j] + " ");
            }
            System.out.println();
        }

        int iRowToRemove = rand.nextInt(iRows);
        int iColToRemove = rand.nextInt(iCols);

        System.out.println("\nУдаляем строку: " + (iRowToRemove+1) + ", столбец: " + (iColToRemove+1));

        int iNewRows = iRows - 1;
        int iNewCols = iCols - 1;

        int[][] result = new int[iNewRows][iNewCols];

        int iNewRow = 0;
        for (int i = 0; i < iRows; i++) {
            if (i == iRowToRemove) continue;

            int iNewCol = 0;
            for (int j = 0; j < iCols; j++) {
                if (j == iColToRemove) continue;
                result[iNewRow][iNewCol] = iRectangle[i][j];
                iNewCol++;
            }
            iNewRow++;
        }

        System.out.println("\nНовый массив (без строки " + (iRowToRemove+1) + " и столбца " + (iColToRemove+1) + "):");

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

        in.close();
    }
}
