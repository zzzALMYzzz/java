package lr6;

public class example10 {
    public static int[] getMinMax(int... numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Должен быть передан хотя бы один аргумент");
        }

        int min = numbers[0];
        int max = numbers[0];

        for (int num : numbers) {
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
        }

        return new int[]{max, min};
    }

    public static void main(String[] args) {
        int[] result = getMinMax(5, -3, 10, 7, 0, 8);
        System.out.println("Максимум: " + result[0]);
        System.out.println("Минимум: " + result[1]);
    }
}
