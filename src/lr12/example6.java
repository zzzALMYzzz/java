package lr12;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class example6 {  
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; 
        System.out.println("Сумма элементов: " + sumMultithreaded(array));
    }

    public static long sumMultithreaded(int[] array) throws ExecutionException, InterruptedException {
        int cores = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(cores);
        List<Future<Long>> futures = new ArrayList<>();
        
        int chunkSize = (int) Math.ceil((double) array.length / cores);

        for (int i = 0; i < cores; i++) {
            final int start = i * chunkSize;
            final int end = Math.min(start + chunkSize, array.length);
            
            if (start >= array.length) break;

            futures.add(executor.submit(() -> {
                long sum = 0;
                for (int j = start; j < end; j++) {
                    sum += array[j];
                }
                return sum;
            }));
        }

        long totalSum = 0;
        for (Future<Long> future : futures) {
            totalSum += future.get();
        }

        executor.shutdown();
        return totalSum;
    }
}
