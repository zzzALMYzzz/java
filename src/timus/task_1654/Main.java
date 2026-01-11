package timus.task_1654;

import java.util.Scanner;

public class Main {  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, "cp866");

        String str = in.nextLine();
        StringBuilder sb = new StringBuilder();
        
        for (char c : str.toCharArray()) {
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == c) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(c);
            }
        }

        System.out.println(sb.toString());

        in.close();
    }  
}
