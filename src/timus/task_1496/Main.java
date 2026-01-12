package timus.task_1496;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, "cp866");

        int n = in.nextInt();

        List<String> teams = new ArrayList<String>(n);
        Set<String> result = new HashSet<String>(n);
        for (int i = 0; i <= n; i++) {
            String next = in.nextLine();
            if (teams.contains(next)) {
                result.add(next);
            } else {
                teams.add(next);
            }
        }

        for (String team : result) {
            System.out.println(team);
        }

        in.close();
    }  
}
