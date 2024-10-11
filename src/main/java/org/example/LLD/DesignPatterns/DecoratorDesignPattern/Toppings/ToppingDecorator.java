package org.example.LLD.DesignPatterns.DecoratorDesignPattern.Toppings;

import org.example.LLD.DesignPatterns.DecoratorDesignPattern.Pizza.BasePizza;

public abstract class ToppingDecorator extends BasePizza {
    protected BasePizza pizza;

    public ToppingDecorator(BasePizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public abstract int cost();
}
