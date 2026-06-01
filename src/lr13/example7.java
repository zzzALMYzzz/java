package lr13;

public class example7 {  
    public static void main(String[] args) {
        try {
            System.out.println("0");
            throw new NullPointerException("ошибка");
        } catch (NullPointerException e) {
            System.out.println("1");
            try {
                throw new ArithmeticException();
            } catch (ArithmeticException ex) { // Внутренний перехват
                System.out.println("Внутренний перехват: 2");
            }
        }
        System.out.println("3");
    }
}
