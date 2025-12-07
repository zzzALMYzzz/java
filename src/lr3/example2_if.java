package lr3;

import java.util.Scanner;

public class example2_if {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, "cp866");

        System.out.println("Введите словом день недели: ");
        String iDay = in.nextLine().trim().toLowerCase();

        int number = 0;

        if (iDay.equals("понедельник")) {
            number = 1;
        } else if (iDay.equals("вторник")) {
            number = 2;
        } else if (iDay.equals("среда")) {
            number = 3;
        } else if (iDay.equals("четверг")) {
            number = 4;
        } else if (iDay.equals("пятница")) {
            number = 5;
        } else if (iDay.equals("суббота")) {
            number = 6;
        } else if (iDay.equals("воскресенье")) {
            number = 7;
        } else {
            System.out.println("if: Такого дня недели не существует.");
            in.close();
            return;
        }

        System.out.println("if: Номер дня недели: " + number);

        in.close();
    }
}
