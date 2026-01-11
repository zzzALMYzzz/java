package lr6;

class Counter {
    private static int count = 0;

    public static void showAndIncrement() {
        System.out.println(count);
        count++;
    }
}

public class example2 {
    public static void main(String[] args) {
        Counter.showAndIncrement();
        Counter.showAndIncrement();
        Counter.showAndIncrement();
    }
}
