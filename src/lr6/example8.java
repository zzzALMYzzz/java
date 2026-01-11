package lr6;

public class example8 {
    public static double calculateAverage(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Массив не должен быть пустым или null");
        }

        double sum = java.util.Arrays.stream(array).sum();

        return sum / array.length;
    }

    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};
        double average = calculateAverage(numbers);
        System.out.println("Среднее значение: " + average);
    }
}
