package org.example.LLD.Designs.Threads.Parallel;

class ArrayProcessor implements Runnable {
    private int[] array;
    private int start;
    private int end;

    public ArrayProcessor(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        for (int i = start; i < end; i++) {
            // Process the array element
            array[i] = process(array[i]);  // Example processing function
        }
    }

    private int process(int value) {
        // Example processing logic
        return value * value;
    }
}

