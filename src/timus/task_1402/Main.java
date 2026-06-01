package timus.task_1402;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, "cp866");

        if (in.hasNextInt()) {
            int n = in.nextInt();
            BigInteger totalCocktails = BigInteger.ZERO;
            BigInteger currentPermutation = BigInteger.valueOf(n);

            for (int k = 2; k <= n; k++) {
                currentPermutation = currentPermutation.multiply(BigInteger.valueOf(n - k + 1));
                totalCocktails = totalCocktails.add(currentPermutation);
            }

            System.out.println(totalCocktails);
        }

        in.close();
    }  
}
