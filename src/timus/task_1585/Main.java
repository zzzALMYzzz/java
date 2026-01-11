package timus.task_1585;

import java.util.Scanner;

public class Main {  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, "cp866");

        int n = in.nextInt();
        in.nextLine();
        
        int emperorCount = 0;
        int littleCount = 0;
        int macaroniCount = 0;
        
        for (int i = 0; i < n; i++) {
            String penguinType = in.nextLine();
            
            if (penguinType.equals("Emperor Penguin")) {
                emperorCount++;
            } else if (penguinType.equals("Little Penguin")) {
                littleCount++;
            } else if (penguinType.equals("Macaroni Penguin")) {
                macaroniCount++;
            }
        }
        
        if (emperorCount > littleCount && emperorCount > macaroniCount) {
            System.out.println("Emperor Penguin");
        } else if (littleCount > emperorCount && littleCount > macaroniCount) {
            System.out.println("Little Penguin");
        } else {
            System.out.println("Macaroni Penguin");
        }

        in.close();
    }  
}
