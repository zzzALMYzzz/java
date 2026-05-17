package timus.task_1404;

import java.util.Scanner;

public class Main {  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, "cp866");
        String encrypted = in.nextLine();

        int n = encrypted.length();
        int[] c = new int[n];

        for (int i = 0; i < n; i++) {
            c[i] = encrypted.charAt(i) - 'a';
        }

        StringBuilder decrypted = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int originalValue;
            if (i == 0) {
                originalValue = (c[0] - 5 + 26) % 26;
            } else {
                originalValue = (c[i] - c[i - 1] + 26) % 26;
            }
            decrypted.append((char) (originalValue + 'a'));
        }

        System.out.println(decrypted.toString());
        in.close();
    }  
}
