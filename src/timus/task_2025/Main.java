package timus.task_2025;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        if (!in.hasNextInt()) return;
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int k = in.nextInt();
            int baseSize = n / k;
            int extraTeams = n % k;
            int normalTeams = k - extraTeams;
            long totalPairs = (long) n * (n - 1) / 2;
            long internalPairsExtra = (long) extraTeams * (baseSize + 1) * baseSize / 2;
            long internalPairsNormal = (long) normalTeams * baseSize * (baseSize - 1) / 2;
            long result = totalPairs - internalPairsExtra - internalPairsNormal;
            System.out.println(result);
        }
        in.close();
    }
}
