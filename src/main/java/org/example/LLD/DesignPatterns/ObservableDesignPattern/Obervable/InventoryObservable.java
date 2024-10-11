package org.example.LLD.DesignPatterns.ObservableDesignPattern.Obervable;

import org.example.LLD.DesignPatterns.ObservableDesignPattern.Observers.TvInventoryObserver;

public interface InventoryObservable {
    void add(TvInventoryObserver tvInventoryObservers);
    void remove(TvInventoryObserver tvInventoryObservers);
    void notifyAllObservers();
    void setInventory(int number);
    int getInventory();
}
