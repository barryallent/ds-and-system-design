package org.example.LLD.DesignPatterns.ObservableDesignPattern.Obervable;

import org.example.LLD.DesignPatterns.ObservableDesignPattern.Obervable.InventoryObservable;
import org.example.LLD.DesignPatterns.ObservableDesignPattern.Observers.TvInventoryObserver;

import java.util.ArrayList;
import java.util.List;

public class TvInventoryObservable implements InventoryObservable {
    List<TvInventoryObserver> tvInventoryObservers = new ArrayList<>();

    int tvCount;

    @Override
    public void add(TvInventoryObserver tvInventoryObserver) {
        tvInventoryObservers.add(tvInventoryObserver);
    }

    @Override
    public void remove(TvInventoryObserver tvInventoryObserver) {
        tvInventoryObservers.remove(tvInventoryObserver);
    }

    @Override
    public void notifyAllObservers() {
        for(TvInventoryObserver observer:tvInventoryObservers) {
            observer.update();
        }
    }

    @Override
    public void setInventory(int number) {

        if(tvCount==0) {
            tvCount=number;
            notifyAllObservers();
        }
        else {
            tvCount=number;
        }
    }

    @Override
    public int getInventory() {
        return tvCount;
    }
}
