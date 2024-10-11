package org.example.LLD.DesignPatterns.ObservableDesignPattern.Observers;

import org.example.LLD.DesignPatterns.ObservableDesignPattern.Obervable.InventoryObservable;
import org.example.LLD.DesignPatterns.ObservableDesignPattern.Observers.TvInventoryObserver;

public class TvInventorySMSObserver implements TvInventoryObserver {

    String mobileNumber;

    InventoryObservable observable;

    public TvInventorySMSObserver(String mobileNumber, InventoryObservable observable) {
        this.mobileNumber=mobileNumber;
        this.observable=observable;
    }
    @Override
    public void update() {
        System.out.println("sent sms to observer "+mobileNumber);
        System.out.println("current tv count is = "+observable.getInventory());
    }
}
