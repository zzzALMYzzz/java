package timus.task_1880;

import java.util.*;

public class Main {  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, "cp866");

        int n1 = in.nextInt();
        int arr1[] = new int[n1];
        for (int i = 0; i < n1; i++) {
            arr1[i] = in.nextInt();
        }
        int n2 = in.nextInt();
        int arr2[] = new int[n2];
        for (int i = 0; i < n2; i++) {
            arr2[i] = in.nextInt();
        }
        int n3 = in.nextInt();
        int arr3[] = new int[n3];
        for (int i = 0; i < n3; i++) {
            arr3[i] = in.nextInt();
        }

        LinkedList<Integer> match = new LinkedList<Integer>();
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                if (arr1[i] < arr2[j]) {
                    break;
                } else if (arr1[i] == arr2[j]) {
                    match.addLast(arr1[i]);
                    break;
                }
            }
        }

        int result = 0;
        for (int next : match) {
            for (int j = 0; j < n3; j++) {
                if (next < arr3[j]) {
                    break;
                } else if (next == arr3[j]) {
                    result++;
                }
            }
        }

        System.out.println(result);
        in.close();
    }  
}
