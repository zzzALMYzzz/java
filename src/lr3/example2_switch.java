package lr3;

import java.util.Scanner;

public class example2_switch {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, "cp866");

        System.out.println("Введите словом день недели: ");
        String iDay = in.nextLine().trim().toLowerCase();

        int number = 0;

        switch (iDay) {
            case "понедельник":
                number = 1;
                break;
            case "вторник":
                number = 2;
                break;
            case "среда":
                number = 3;
                break;
            case "четверг":
                number = 4;
                break;
            case "пятница":
                number = 5;
                break;
            case "суббота":
                number = 6;
                break;
            case "воскресенье":
                number = 7;
                break;
            default:
                System.out.println("switch: Такого дня недели не существует.");
                in.close();
                return;
        }

        System.out.println("switch: Номер дня недели: " + number);

        in.close();
    }
}
