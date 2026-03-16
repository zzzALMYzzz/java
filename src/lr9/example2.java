package lr9;

import java.util.Scanner;

public class example2 {  
    public static void toBinary(int n) {
        if (n > 1) {
            toBinary(n / 2);
        }
        System.out.print(n % 2);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, "cp866");
        System.out.println("Введите число: ");
        int iNum = in.nextInt();
        if(iNum != 0) toBinary(iNum);
        in.close();
    }  
}
