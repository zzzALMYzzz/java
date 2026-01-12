package timus.task_1567;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, "cp866");

        String letters = "abcdefghijklmnopqrstuvwxyz";
        Map<Character, Integer> map = new HashMap<Character, Integer>(letters.length());

        int counter = 1;
        for (int i = 0; i < letters.length(); i++) {
            if (counter == 4) {
                counter = 1;
            }
            Character c = letters.charAt(i);
            map.put(c, counter);
            counter++;
        }

        map.put('.', 1);
        map.put(',', 2);
        map.put('!', 3);
        map.put('_', 1);
        map.put(' ', 1);

        String line = in.nextLine();
        int cost = 0;
        for (int i = 0; i < line.length(); i++) {
            cost += map.get(line.charAt(i));
        }
        System.out.println(cost);

        in.close();
    }  
}
