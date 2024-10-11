package org.example.LLD.DesignPatterns.ObservableDesignPattern.Observers;

import org.example.LLD.DesignPatterns.ObservableDesignPattern.Obervable.InventoryObservable;

public class TvInventoryEmailObserver implements TvInventoryObserver {

    String emailId;

    InventoryObservable observable;

    public TvInventoryEmailObserver(String emailId, InventoryObservable observable) {
        this.emailId=emailId;
        this.observable=observable;
    }
    @Override
    public void update() {
        System.out.println("sent sms to observer"+emailId);
        System.out.println("current tv count is = "+observable.getInventory());
    }
}
