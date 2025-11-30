package timus.task_1131;

import java.util.Scanner;

public class Main {  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, "cp866");
        
        long N = in.nextInt();
        long K = in.nextInt();

        if(N == 1) {
            System.out.println("Ошибка");
            System.exit(1);
        }

        long iTime = 0, iNumCompProg = 1, iCopies = 0;

        while (iNumCompProg < N) {
            iCopies = Math.min(iNumCompProg, K);
            iNumCompProg += iCopies;
            iTime++;

            if(iNumCompProg >= N) break;
        }
        
        System.out.println("Результат: " + iTime);
        in.close();
    }  
}
