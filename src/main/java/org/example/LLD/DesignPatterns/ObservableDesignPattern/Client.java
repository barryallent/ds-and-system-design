package org.example.LLD.DesignPatterns.ObservableDesignPattern;

import org.example.LLD.DesignPatterns.ObservableDesignPattern.Obervable.InventoryObservable;
import org.example.LLD.DesignPatterns.ObservableDesignPattern.Obervable.TvInventoryObservable;
import org.example.LLD.DesignPatterns.ObservableDesignPattern.Observers.TvInventoryEmailObserver;
import org.example.LLD.DesignPatterns.ObservableDesignPattern.Observers.TvInventoryObserver;
import org.example.LLD.DesignPatterns.ObservableDesignPattern.Observers.TvInventorySMSObserver;

public class Client {
    public static void main(String[] args) {

        //creating tv observable
        InventoryObservable tvInventoryObservable = new TvInventoryObservable();


        //creating 2 observers which are watching tv, so we pass tv in constructor. If they watch something else like
        //weather then we can pass weather object, but right now we have tv only
        TvInventoryObserver tvInventoryEmailObserver= new TvInventoryEmailObserver("abhinav.t@gmail.com",tvInventoryObservable);
        TvInventoryObserver tvInventorySmsObserver = new TvInventorySMSObserver("9897801734", tvInventoryObservable);

        //adding observers to the list
        tvInventoryObservable.add(tvInventoryEmailObserver);
        tvInventoryObservable.add(tvInventorySmsObserver);

        //setting intial stock from 0 to 100 so will receive email
        tvInventoryObservable.setInventory(100);

        //now inventory count is 0 again
        tvInventoryObservable.setInventory(0);

        //since inventory count was so when we set to 3 so all observers will be notified again
        tvInventoryObservable.setInventory(3);

        //just checking notify all method
        tvInventoryObservable.notifyAllObservers();

    }
}
