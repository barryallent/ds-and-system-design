package org.example.LLD.Designs.Threads.Parallel;

public class ParallelProcessingExample {
    public static void main(String[] args) throws InterruptedException {
        int[] array = new int[1000];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }

        int numThreads = 4;  // Number of parallel threads
        Thread[] threads = new Thread[numThreads];
        int segmentSize = array.length / numThreads;

        for (int i = 0; i < numThreads; i++) {
            int start = i * segmentSize;
            int end = (i == numThreads - 1) ? array.length : (i + 1) * segmentSize;
            threads[i] = new Thread(new ArrayProcessor(array, start, end));
            threads[i].start();
        }

        // Wait for all threads to complete
        for (Thread thread : threads) {
            thread.join();
        }

        // Print the processed array (for verification)
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}

