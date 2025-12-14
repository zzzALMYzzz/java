package lr4;

public class example2 {
    public static void main(String[] args) {
        int iHeight = 10;

        for (int i = 1; i <= iHeight; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
