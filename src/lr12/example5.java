package lr12;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class example5 {  
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 1000);
        }
        System.out.println("Максимальный элемент: " + findMaxMultithreaded(array));
    }

    public static int findMaxMultithreaded(int[] array) throws ExecutionException, InterruptedException {
        int cores = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(cores);
        List<Future<Integer>> futures = new ArrayList<>();
        
        int chunkSize = (int) Math.ceil((double) array.length / cores);

        for (int i = 0; i < cores; i++) {
            final int start = i * chunkSize;
            final int end = Math.min(start + chunkSize, array.length);
            
            if (start >= array.length) break;

            futures.add(executor.submit(() -> {
                int max = Integer.MIN_VALUE;
                for (int j = start; j < end; j++) {
                    if (array[j] > max) {
                        max = array[j];
                    }
                }
                return max;
            }));
        }

        int globalMax = Integer.MIN_VALUE;
        for (Future<Integer> future : futures) {
            globalMax = Math.max(globalMax, future.get());
        }

        executor.shutdown();
        return globalMax;
    }
}
