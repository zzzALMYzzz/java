package lr9;

import java.util.ArrayList;
import java.util.Scanner;

public class example7_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите количество людей N: ");
        int N = in.nextInt();

        ArrayList<Integer> circle = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            circle.add(i);
        }

        long start = System.nanoTime();
        int index = 0;
        while (circle.size() > 1) {
            index = (index + 1) % circle.size();
            circle.remove(index);
        }
        long end = System.nanoTime();

        System.out.println("Оставшийся (ArrayList): " + circle.get(0));
        System.out.println("Время выполнения (ArrayList): " + (end - start) / 1_000_000.0 + " мс");
        in.close();
    }
}
