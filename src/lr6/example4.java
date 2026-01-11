package lr6;

public class example4 {
    public static long doubleFactorial(int n) {
        if (n <= 0) {
            return 1;
        }
        long result = 1;
        for (int i = n; i > 0; i -= 2) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("6!! = " + doubleFactorial(6));
        System.out.println("5!! = " + doubleFactorial(5));
        System.out.println("4!! = " + doubleFactorial(4));
        System.out.println("3!! = " + doubleFactorial(3));
        System.out.println("2!! = " + doubleFactorial(2));
        System.out.println("1!! = " + doubleFactorial(1));
    }
}
