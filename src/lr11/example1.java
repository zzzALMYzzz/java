package lr11;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class example1 {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] array2 = {5, 6, 7, 8, 15, 20};
        List<Integer> intList = List.of(1, 2, 3, 4, 5, 10, 15, 20, 25);
        List<String> stringList = List.of("Яблоко", "банан", "Груша", "апельсин123", "Киви", "Дыня!");

        System.out.println("--- Задание 1: Четные числа ---");
        System.out.println("Исходный массив: " + Arrays.toString(array1));
        System.out.println("Результат: " + Arrays.toString(filterEvenNumbers(array1)) + "\n");

        System.out.println("--- Задание 2: Общие элементы массивов ---");
        System.out.println("Массив 1: " + Arrays.toString(array1));
        System.out.println("Массив 2: " + Arrays.toString(array2));
        System.out.println("Результат: " + Arrays.toString(findCommonElements(array1, array2)) + "\n");

        System.out.println("--- Задание 3: Строки с большой буквы ---");
        System.out.println("Исходный список: " + stringList);
        System.out.println("Результат: " + filterCapitalizedStrings(stringList) + "\n");

        System.out.println("--- Задание 4: Квадраты чисел ---");
        System.out.println("Исходный список: " + intList);
        System.out.println("Результат: " + squareList(intList) + "\n");

        System.out.println("--- Задание 5: Строки с подстрокой 'ан' ---");
        System.out.println("Исходный список: " + stringList);
        System.out.println("Результат: " + filterBySubstring(stringList, "ан") + "\n");

        System.out.println("--- Задание 6: Числа, делящиеся на 5 ---");
        System.out.println("Исходный список: " + intList);
        System.out.println("Результат: " + filterDivisibleBy(intList, 5) + "\n");

        System.out.println("--- Задание 7: Строки длиннее 5 символов ---");
        System.out.println("Исходный список: " + stringList);
        System.out.println("Результат: " + filterByLengthGreater(stringList, 5) + "\n");

        System.out.println("--- Задание 8: Числа больше 10 ---");
        System.out.println("Исходный список: " + intList);
        System.out.println("Результат: " + filterGreaterThan(intList, 10) + "\n");

        System.out.println("--- Задание 9: Строки, содержащие только буквы (без цифр и знаков) ---");
        System.out.println("Исходный список: " + stringList);
        System.out.println("Результат: " + filterOnlyLetters(stringList) + "\n");

        System.out.println("--- Задание 10: Числа меньше 5 ---");
        System.out.println("Исходный список: " + intList);
        System.out.println("Результат: " + filterLessThan(intList, 5) + "\n");
    }

    public static int[] filterEvenNumbers(int[] arr) {
        return Arrays.stream(arr).filter(x -> x % 2 == 0).toArray();
    }

    public static int[] findCommonElements(int[] arr1, int[] arr2) {
        return Arrays.stream(arr1).filter(x -> Arrays.stream(arr2).anyMatch(y -> y == x)).distinct().toArray();
    }

    public static List<String> filterCapitalizedStrings(List<String> list) {
        return list.stream().filter(s -> s != null && !s.isEmpty() && Character.isUpperCase(s.charAt(0))).collect(Collectors.toList());
    }

    public static List<Integer> squareList(List<Integer> list) {
        return list.stream().map(x -> x * x).collect(Collectors.toList());
    }

    public static List<String> filterBySubstring(List<String> list, String substring) {
        return list.stream().filter(s -> s != null && s.contains(substring)).collect(Collectors.toList());
    }

    public static List<Integer> filterDivisibleBy(List<Integer> list, int divisor) {
        return list.stream().filter(x -> x % divisor == 0).collect(Collectors.toList());
    }

    public static List<String> filterByLengthGreater(List<String> list, int length) {
        return list.stream().filter(s -> s != null && s.length() > length).collect(Collectors.toList());
    }

    public static List<Integer> filterGreaterThan(List<Integer> list, int threshold) {
        return list.stream().filter(x -> x > threshold).collect(Collectors.toList());
    }

    public static List<String> filterOnlyLetters(List<String> list) {
        return list.stream().filter(s -> s != null && !s.isEmpty() && s.chars().allMatch(Character::isLetter)).collect(Collectors.toList());
    }

    public static List<Integer> filterLessThan(List<Integer> list, int threshold) {
        return list.stream().filter(x -> x < threshold).collect(Collectors.toList());
    }
}