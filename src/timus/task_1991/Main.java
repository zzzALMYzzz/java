package timus.task_1991;

import java.util.Scanner;

public class Main {  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, "cp866");

        int SvdB = 0, SrvvdS = 0;
        int n = in.nextInt();
        int k = in.nextInt();
        
        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            int Dif = k - a;
            if (Dif > 0) {
                SrvvdS += Dif;
            } else if (Dif < 0) {
                SvdB += Math.abs(Dif);
            }
        }
        
        System.out.println(SvdB + " " + SrvvdS);

        in.close();
    }  
}
