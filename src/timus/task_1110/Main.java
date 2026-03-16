package timus.task_1110;

import java.util.*;

public class Main {  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, "cp866");
        try {
            int N = in.nextInt();
            byte max = 0;
            int id[] = new int[N];
            byte M[]  = new byte[N];
            for (int i = 0; i < N; i++) {
                id[i] = in.nextInt();
                M[i] = in.nextByte();
                if (M[i] > max){
                    max = M[i];
                }
            }

            for (int i = max; i >= 0; i --){
                  for (int j = 0; j < N; j ++){
                      if (M[j] == i){
                          System.out.print(id[j] + " ");
                          System.out.println(M[j]);
                      }
                  }
            }
        } finally {
            in.close();
        }
    }  
}
