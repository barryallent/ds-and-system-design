package org.example.LLD.DesignPatterns.DecoratorDesignPattern.Toppings;

import org.example.LLD.DesignPatterns.DecoratorDesignPattern.Pizza.BasePizza;

public class MushroomDecorator extends ToppingDecorator{

    public MushroomDecorator(BasePizza pizza) {
        super(pizza);
    }
    @Override
    public int cost() {
        return pizza.cost()+30;
    }
}
