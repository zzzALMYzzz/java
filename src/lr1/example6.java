package lr1;

import java.util.Scanner;

public class example6 {  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, "cp866");

        System.out.println("Введите фамилию: ");
        String familiya = in.nextLine();

        System.out.println("Введите имя: ");
        String name = in.nextLine();

        System.out.println("Введите отчество: ");
        String otchestvo = in.nextLine();

        System.out.println("Hello, " + familiya + " " + name + " " + otchestvo);
        in.close();
    }  
}