package timus.task_1206;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, "cp866");

        if (in.hasNextInt()) {
            int k = in.nextInt();
            BigInteger result = BigInteger.valueOf(36);
            BigInteger multiplier = BigInteger.valueOf(55);

            for (int i = 0; i < k - 1; i++) {
                result = result.multiply(multiplier);
            }

            System.out.println(result);
        }

        in.close();
    }  
}
