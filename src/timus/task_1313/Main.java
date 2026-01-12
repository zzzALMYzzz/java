package timus.task_1313;

import java.util.Scanner;

public class Main {  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, "cp866");

        int n = in.nextInt();

        if(n <= 0 || n >= 101) {
            System.out.print("Ошибка"); 
            System.exit(0);
        }

        int[][] a = new int[n+1][n+1];

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                a[i][j] = in.nextInt();
            }
        }

        for(int i = 1; i <= n; i++) {
            int x = i, y = 1 ;
            while(x >= 1 && x <= n){
                System.out.print(a[x][y] + " ");
                x--; 
                y++;
            }
        }

        for(int i = 1; i < n; i++) {
            int x = n, y = i+1;
            while(y >= 1 && y <= n){
                System.out.print(a[x][y] + " ");
                x--; 
                y++;
            }
        }

        in.close();
    }  
}
