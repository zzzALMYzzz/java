package timus.task_1740;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {  
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String line = br.readLine();
            if (line == null) return;
            
            StringTokenizer st = new StringTokenizer(line);
            int l = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            
            double minTime = (double) (l / k) * h;
            double maxTime = (double) ((l + k - 1) / k) * h;
            
            System.out.printf("%.5f %.5f\n", minTime, maxTime);
            
        } catch (IOException e) {
            e.printStackTrace();
        }

    }  
}
