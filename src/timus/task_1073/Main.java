package timus.task_1073;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {  
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        if (line == null || line.trim().isEmpty()) return;
        
        int n = Integer.parseInt(line.trim());
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = i;
        }
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                int square = j * j;
                if (dp[i - square] + 1 < dp[i]) {
                    dp[i] = dp[i - square] + 1;
                }
            }
        }

        System.out.println(dp[n]);
    }  
}
