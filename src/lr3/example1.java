package lr3;

import java.util.Scanner;

public class example1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, "cp866");

        System.out.println("Введите число от 1 до 7: ");
        int iNum = in.nextInt();

        String result;
        
        switch (iNum) {
            case 1:
                result = "Понедельник";
                break;
            case 2:
                result = "Вторник";
                break;
            case 3:
                result = "Среда";
                break;
            case 4:
                result = "Четверг";
                break;
            case 5:
                result = "Пятница";
                break;
            case 6:
                result = "Суббота";
                break;
            case 7:
                result = "Воскресенье";
                break;
            default:
                result = "Некорректное значение. Введите число от 1 до 7.";
                break;
        }
        
        System.out.println(result);

        in.close();
    }
}
