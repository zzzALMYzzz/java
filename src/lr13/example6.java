package lr13;

public class example6 {  
    public static void main(String[] args) {
        try {
            System.out.println("0");
            throw new NullPointerException("ошибка");
        } catch (ArithmeticException e) {
            System.out.println("1");
        } catch (RuntimeException e) { // Перемещено выше Exception
            System.out.println("3");
        } catch (Exception e) { // Перемещено в конец иерархии
            System.out.println("2");
        }
        System.out.println("4");
    }
}
