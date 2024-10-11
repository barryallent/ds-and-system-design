package org.example.LLD.Designs.Threads.Safe;

import lombok.Getter;

class ThreadSafe {
    @Getter
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

}