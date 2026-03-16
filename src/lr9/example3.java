package lr9;

import java.util.Scanner;

public class example3 {  
    public static void inputArray(int[] arr, int index, Scanner scanner) {
        if (index == arr.length) {
            return;
        }
        System.out.print("Введите элемент [" + index + "]: ");
        arr[index] = scanner.nextInt();
        inputArray(arr, index + 1, scanner);
    }

    public static void outputArray(int[] arr, int index) {
        if (index == arr.length) {
            return;
        }
        System.out.println("Элемент [" + index + "] = " + arr[index]);
        outputArray(arr, index + 1);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, "cp866");
        System.out.println("Введите число: ");
        int iNum = in.nextInt();
        int[] array = new int[iNum];
        System.out.println("Ввод элементов массива:");
        inputArray(array, 0, in);
        System.out.println();
        System.out.println("Вывод элементов массива:");
        outputArray(array, 0);
        in.close();
    }  
}
