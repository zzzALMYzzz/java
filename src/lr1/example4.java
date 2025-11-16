import java.util.Scanner;

public class example4 {  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, "cp866");
        System.out.println("Введите число: ");
        int iNum = in.nextInt();
        System.out.println("Ваше число: " + iNum);
        in.close();
    }  
}