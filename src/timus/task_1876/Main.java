package timus.task_1876;

import java.util.*;

public class Main {  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, "cp866");
        int a = in.nextInt() << 1;
        int b = in.nextInt() << 1;
        System.out.println(Math.max(a + 39, b + 40));
        in.close();
    }  
}
