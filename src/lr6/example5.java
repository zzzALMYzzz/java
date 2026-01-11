package lr6;

public class example5 {
    public static long sumOfSquares(int n) {
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i * i;
        }
        return sum;
    }

    public static long sumByFormula(int n) {
        return (long) n * (n + 1) * (2 * n + 1) / 6;
    }

    public static void main(String[] args) {
        int n = 10;

        long result1 = sumOfSquares(n);
        long result2 = sumByFormula(n);

        System.out.println("Сумма квадратов от 1 до " + n + " (через цикл): " + result1);
        System.out.println("Сумма по формуле: " + result2);

        if (result1 == result2) {
            System.out.println("Проверка пройдена: результаты совпадают.");
        } else {
            System.out.println("Ошибка: результаты не совпадают.");
        }
    }
}
