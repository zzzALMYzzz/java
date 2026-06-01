package lr13;

import java.util.InputMismatchException;
import java.util.Scanner;

public class example21 {  
public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Введите размерность одномерного массива: ");
            int size = scanner.nextInt();
            
            int[] array = new int[size];
            System.out.println("Введите элементы массива (целые числа):");
            for (int i = 0; i < size; i++) {
                array[i] = scanner.nextInt();
            }

            int sum = 0;
            int count = 0;
            for (int num : array) {
                if (num > 0) {
                    sum += num;
                    count++;
                }
            }

            int average = sum / count; 
            System.out.println("Среднее значение положительных элементов: " + average);

        } catch (InputMismatchException e) {
            System.out.println("[Ошибка]: Введена строка или несоответствующий тип данных вместо целого числа!");
        } catch (ArithmeticException e) {
            System.out.println("[Ошибка]: Положительные элементы в массиве отсутствуют (деление на ноль)!");
        } finally {
            System.out.println("[Ресурсы]: Освобождение ресурсов сканера.");
            scanner.close();
        }
    }
}
