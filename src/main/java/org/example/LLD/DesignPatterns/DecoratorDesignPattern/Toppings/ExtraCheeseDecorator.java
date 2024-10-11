package org.example.LLD.DesignPatterns.DecoratorDesignPattern.Toppings;

import org.example.LLD.DesignPatterns.DecoratorDesignPattern.Pizza.BasePizza;

public class ExtraCheeseDecorator extends ToppingDecorator{

    public ExtraCheeseDecorator(BasePizza pizza) {
        super(pizza);
    }
    @Override
    public int cost() {
        return pizza.cost()+60;
    }
}
