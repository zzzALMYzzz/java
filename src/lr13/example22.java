package lr13;

import java.util.InputMismatchException;
import java.util.Scanner;

public class example22 {  
    public static void main(String[] args) {
        int[][] matrix = {
            {10, 20, 30},
            {40, 50, 60},
            {70, 80, 90}
        };
        
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Введите номер столбца для вывода (индексация с 0): ");
            int colIndex = scanner.nextInt();

            System.out.println("Элементы столбца " + colIndex + ":");
            for (int i = 0; i < matrix.length; i++) {
                System.out.println(matrix[i][colIndex]);
            }

        } catch (InputMismatchException e) {
            System.out.println("[Ошибка]: Вместо номера столбца введена строка!");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("[Ошибка]: Столбец с таким номером отсутствует в матрице!");
        } finally {
            System.out.println("[Ресурсы]: Сканер успешно закрыт.");
            scanner.close();
        }
    }
}
