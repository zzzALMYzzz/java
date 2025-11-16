import java.util.Scanner;

public class example15 {  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, "cp866");

        System.out.println("Введите первое число: ");
        int num_1 = in.nextInt();

        System.out.println("Введите второе число: ");
        int num_2 = in.nextInt();

        System.out.println("Сумма: " + (num_1 + num_2));
        System.out.println("Разность: " + (num_1 - num_2));
        in.close();
    }  
}