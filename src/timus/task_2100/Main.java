package timus.task_2100;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, "cp866");

        int MarshalAndLilly = 2;
        int NumberOfPairs = 0;

        int n = in.nextInt();
        if(n <= 0 || n >= 21) {
            System.out.print("Ошибка"); 
            System.exit(0);
        }

        String str;

        ArrayList<String> guests = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            str = in.nextLine();
            guests.add(str);
            if(guests.get(i).contains("+one")) NumberOfPairs++;
        }
    
        int quests = MarshalAndLilly + n + NumberOfPairs;

        if(quests == 13) {
            System.out.println((quests * 100) + 100);
        } else {
            System.out.println(quests * 100);
        }

        in.close();
    }  
}
