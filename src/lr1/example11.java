import java.util.Scanner;

public class example11 {  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, "cp866");

        System.out.println("Введите имя: ");
        String name = in.nextLine();

        System.out.println("Введите год рождения: ");
        int num_year = in.nextInt();

        int Age = 2025 - num_year;

        System.out.println(name + " " + Age + " лет");
        in.close();
    }  
}