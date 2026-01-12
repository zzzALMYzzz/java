package timus.task_1100;

import java.io.*;
import java.util.*;

public class Main {
    static class Person {
        int id, m, index;
        Person(int id, int m, int index) {
            this.id = id;
            this.m = m;
            this.index = index;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Person[] arr = new Person[N];

        for (int i = 0; i < N; i++) {
            String[] parts = br.readLine().split(" ");
            int id = Integer.parseInt(parts[0]);
            int m = Integer.parseInt(parts[1]);
            arr[i] = new Person(id, m, i);
        }

        Arrays.sort(arr, new Comparator<Person>() {
            public int compare(Person a, Person b) {
                if (a.m != b.m) {
                    return Integer.compare(b.m, a.m);
                }
                return Integer.compare(a.index, b.index);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (Person p : arr) {
            sb.append(p.id).append(' ').append(p.m).append('\n');
        }
        System.out.print(sb);

        br.close();
    }
}
