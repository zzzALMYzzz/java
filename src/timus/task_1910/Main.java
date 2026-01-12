package timus.task_1910;

import java.util.Scanner;

public class Main {  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, "cp866");

        int n = in.nextInt();

        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int msum = 0;
        int position = 0;
        for (int i = 0; i < n - 2; i++) {
            int sum = arr[i] + arr[i + 1] + arr[i + 2];
            if (sum > msum) {
                msum = sum;
                position = i + 2;
            }
        }

        System.out.print(msum + " " + position);

        in.close();
    }  
}
