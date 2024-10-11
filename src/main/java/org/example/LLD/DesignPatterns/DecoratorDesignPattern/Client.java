package org.example.LLD.DesignPatterns.DecoratorDesignPattern;

import org.example.LLD.DesignPatterns.DecoratorDesignPattern.Pizza.BasePizza;
import org.example.LLD.DesignPatterns.DecoratorDesignPattern.Pizza.Margherita;
import org.example.LLD.DesignPatterns.DecoratorDesignPattern.Pizza.VeggieParadise;
import org.example.LLD.DesignPatterns.DecoratorDesignPattern.Toppings.ExtraCheeseDecorator;
import org.example.LLD.DesignPatterns.DecoratorDesignPattern.Toppings.MushroomDecorator;

public class Client {
    public static void main(String[] args) {

//        simple base veggieparadise with no toppings
        BasePizza p1 = new VeggieParadise();
        System.out.println(p1.cost());


        //veggie paradise with extra cheese
        BasePizza p2 = new ExtraCheeseDecorator(new VeggieParadise());
        System.out.println(p2.cost());

        //veggie paradise with extra cheese and mushrooms
        BasePizza p3 = new ExtraCheeseDecorator(new MushroomDecorator(new VeggieParadise()));
        System.out.println(p3.cost());

        //now new toppings can add, and we dont need to make permutations and combinations for each type of different
        //classes with different toppings. we have a base class
        //so we make a topping decorator which extends the base pizza and also has a base pizza, this is the main crux
        //because it extends the base pizza so it has the cost method. Also it has a basepizza so we do constructor injection
        //so we design a base pizza in constructor which can be margherita or margherita+cheese or any other combination
        //basically all of them is a pizza only.
        //when we call new ExtraCheeseDecorator(new MushroomDecorator(new VeggieParadise()));
        //so first veggiepardise constructor would be called then mushroom constructor would be called and basepizza for
        //mushroom is passed as veggiepardise, then extracheese constructor would be called and base pizza would be passed
        //as mushroom+veggiepardise;

        //during p3.cost, so first extracheese cost function would be called, there we have this.cost() that would be called
        //and this is set to mushroom because in extracheese mushroom is passed. so mushroom cost would be called and then
        //veggie paradise cost would be called.
    }
}
