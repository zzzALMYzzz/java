package lr12;

public class example3 {  
    private static final Object lock = new Object();
    private static int number = 1;

    public static void main(String[] args) {
        Thread oddThread = new Thread(() -> printNumbers(false), "Odd Thread");
        Thread evenThread = new Thread(() -> printNumbers(true), "Even Thread");

        oddThread.start();
        evenThread.start();
    }

    private static void printNumbers(boolean isEven) {
        synchronized (lock) {
            while (number <= 10) {
                if ((number % 2 == 0) == isEven) {
                    System.out.println(Thread.currentThread().getName() + ": " + number);
                    number++;
                    lock.notifyAll();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }
}
