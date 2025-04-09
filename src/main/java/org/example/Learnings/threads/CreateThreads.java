package org.example.Learnings.threads;

public class CreateThreads {
    public static void main(String[] args) {

        ChangeResponse changeResponse = new ChangeResponse();
        changeResponse.start();

        DNSService dnsService = new DNSService();
        Thread thread = new Thread(dnsService);
        thread.start();

        for(int i=0;i<100;i++) {
            System.out.println( "Main thread");
        }

    }
}
