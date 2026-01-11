package lr6;

public class example3 {
    public static int max(int... numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Массив пуст или null");
        }
        int max = numbers[0];
        for (int num : numbers) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public static int min(int... numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Массив пуст или null");
        }
        int min = numbers[0];
        for (int num : numbers) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    public static double average(int... numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Массив пуст или null");
        }
        long sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return (double) sum / numbers.length;
    }

    public static void main(String[] args) {
        System.out.println("Максимум: " + max(3, 7, 2, 9, 1, 5));
        System.out.println("Минимум: " + min(3, 7, 2, 9, 1, 5));
        System.out.println("Среднее: " + average(3, 7, 2, 9, 1, 5));

        int[] array = {10, 5, 8, 3, 12, 7};
        System.out.println("Максимум (массив): " + max(array));
        System.out.println("Минимум (массив): " + min(array));
        System.out.println("Среднее (массив): " + average(array));
    }
}
