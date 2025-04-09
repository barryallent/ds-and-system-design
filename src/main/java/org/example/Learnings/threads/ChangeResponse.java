package org.example.Learnings.threads;

public class ChangeResponse extends Thread{
    @Override
    public void run() {
        for(int i=0;i<10;i++) {
            System.out.println(Thread.currentThread().getName()+ " " +"Changing response");
        }
    }
}
