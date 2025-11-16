import java.util.Scanner;

public class example12 {  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, "cp866");

        System.out.println("Введите возраст: ");
        int Age = in.nextInt();

        int num_year = 2025 - Age;

        System.out.println(num_year + " года рождения");
        in.close();
    }  
}