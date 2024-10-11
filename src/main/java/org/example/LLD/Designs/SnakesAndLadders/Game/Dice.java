package org.example.LLD.Designs.SnakesAndLadders.Game;

import java.util.Random;

public class Dice {
    int numberOfDice;
    int diceMin=1;
    int diceMax=6;

    Dice(int numberOfDice) {
        this.numberOfDice=numberOfDice;
    }
    int rollDice(int numberOfDice) {
        int score=0;
        Random r1 = new Random();
        while(numberOfDice>0) {
            score+=r1.nextInt(diceMin,diceMax);
            numberOfDice--;
        }
        return score;
    }
}
