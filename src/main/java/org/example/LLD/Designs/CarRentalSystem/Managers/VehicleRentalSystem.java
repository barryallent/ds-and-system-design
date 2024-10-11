package org.example.LLD.Designs.CarRentalSystem.Managers;

import org.example.LLD.Designs.CarRentalSystem.Store.Location;
import org.example.LLD.Designs.CarRentalSystem.Store.Store;
import org.example.LLD.Designs.CarRentalSystem.User.User;

import java.util.ArrayList;
import java.util.List;
public class VehicleRentalSystem {
    List<Store> stores;
    List<User> users;
    public VehicleRentalSystem(List<Store> stores, List<User> users) {
        this.stores=stores;
        this.users=users;
    }
    public List<Store> findStoreByLocation(Location location) {
        List<Store> stores1 = new ArrayList<>();
        Store s1 = Store.builder().build();
        stores1.add(s1);
        //logic to find stores by location from DB
        return stores1;
    }

}
