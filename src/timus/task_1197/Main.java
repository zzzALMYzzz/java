package timus.task_1197;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {  
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
        final int size = 8;
        int dx[] = {-2, -2, 2, 2, -1, 1, -1, 1};
        int dy[] = {1, -1, 1, -1, 2, 2, -2, -2};

        int n = Integer.parseInt(buffer.readLine());
        List<String> tests = new ArrayList<String>(n);
        for (int i = 0; i < n; i++) {
            tests.add(buffer.readLine().toLowerCase());
        }

        for (String next : tests) {
            int column = next.charAt(0) - 'a';
            int row = next.charAt(1) - '1';

            int positionCount = 0;
            int currentX = 0;
            int currentY = 0;
            for (int i = 0; i < size; i++) {
                currentX = column + dx[i];
                currentY = row + dy[i];
                if (currentX >= 0 && currentX < size
                        && currentY >= 0 && currentY < size) {
                    positionCount++;
                }
            }
            System.out.println(positionCount);
        }
    }  
}
