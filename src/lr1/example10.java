import java.util.Scanner;

public class example10 {  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, "cp866");

        System.out.println("Введите год дня рождения: ");
        int num_year = in.nextInt();

        int Age = 2025 - num_year;

        System.out.println("Возраст: " + Age);
        in.close();
    }  
}