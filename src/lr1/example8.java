package lr1;

import java.util.Scanner;

public class example8 {  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, "cp866");

        System.out.println("Введите день недели: ");
        String den_nedely = in.nextLine();

        System.out.println("Введите названия месяца: ");
        String name_mesyc = in.nextLine();

        System.out.println("Введите номер дня в месяце: ");
        int num_day = in.nextInt();

        System.out.println("Сегодня: " + den_nedely + ", " + num_day + " " + name_mesyc);
        in.close();
    }  
}