package lr13;

import java.util.InputMismatchException;
import java.util.Scanner;

public class example23 {  
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Введите количество элементов массива: ");
            int size = scanner.nextInt();
            
            byte[] array = new byte[size];
            System.out.println("Введите элементы типа byte (диапазон от -128 до 127):");
            for (int i = 0; i < size; i++) {
                array[i] = scanner.nextByte(); 
            }

            int temporarySum = 0;
            for (byte b : array) {
                temporarySum += b;
                if (temporarySum < Byte.MIN_VALUE || temporarySum > Byte.MAX_VALUE) {
                    throw new ArithmeticException("Вычисленное значение вышло за границы диапазона типа byte!");
                }
            }

            System.out.println("Итоговая сумма элементов: " + (byte) temporarySum);
        } catch (InputMismatchException e) {
            System.out.println("[Ошибка]: Введена строка или число вне допустимого диапазона типа byte (-128...127)!");
        } catch (ArithmeticException e) {
            System.out.println("[Ошибка вычисления]: " + e.getMessage());
        } finally {
            System.out.println("[Ресурсы]: Завершение обработки потока ввода.");
            scanner.close();
        }
    }
}
