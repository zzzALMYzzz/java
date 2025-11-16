import java.util.Scanner;

public class example9 {  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, "cp866");

        System.out.println("Введите названия месяца: ");
        String name_mesyc = in.nextLine();

        System.out.println("Введите количество дней в месяце: ");
        int num_day = in.nextInt();

        System.out.println("В месяце " + name_mesyc + " дней: " + num_day);
        in.close();
    }  
}