package org.example.LLD.DesignPatterns.AdapterDesignPattern.Client;

import org.example.LLD.DesignPatterns.AdapterDesignPattern.Adaptee.WeightMachineForBabies;
import org.example.LLD.DesignPatterns.AdapterDesignPattern.Adapter.WeightMachineAdapter;
import org.example.LLD.DesignPatterns.AdapterDesignPattern.Adapter.WeightMachineAdapterImpl;

public class Main {

    public static void main(String args[]){

        WeightMachineAdapter weightMachineAdapter = new WeightMachineAdapterImpl(new WeightMachineForBabies());
        System.out.println(weightMachineAdapter.getWeightInKg());
    }
}
