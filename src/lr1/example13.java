import java.util.Scanner;

public class example13 {  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, "cp866");

        System.out.println("Введите первое число: ");
        int num_1 = in.nextInt();

        System.out.println("Введите второе число: ");
        int num_2 = in.nextInt();

        System.out.println("Итог: " + (num_1 + num_2));
        in.close();
    }  
}