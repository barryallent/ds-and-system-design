package org.example.LLD.Designs.SnakesAndLadders.Game;

import org.example.LLD.Designs.SnakesAndLadders.Player.Player;
import org.example.LLD.Designs.SnakesAndLadders.PlayingBoard.Cell;
import org.example.LLD.Designs.SnakesAndLadders.PlayingBoard.PlayingBoard;

import java.util.List;
import java.util.Scanner;

public class SnakeAndLaddersGame {
    List<Player> playerList;
    PlayingBoard playingBoard;
    Dice dice;

    int numberOfDice;

    public SnakeAndLaddersGame(List<Player> playerList,PlayingBoard playingBoard, int numberOfSnakes, int numberOfLadders, int numberOfDice) {
        this.dice=new Dice(numberOfDice);
        this.playerList=playerList;
        this.playingBoard=playingBoard;
        this.numberOfDice=numberOfDice;
        playingBoard.initializeSnakeAndLadders(numberOfSnakes,numberOfLadders);
    }

    public void playGame() throws InterruptedException {
        System.out.println("Game starts");
        while(!isWinner()) {

            Player p1 = playerList.get(0);
            playerList.remove(0);
            //uncomment this for interactive
//            Scanner sc = new Scanner(System.in);
//            System.out.println("Chance of "+p1.getPlayerName()+": Press 0 to roll dice");
//            int input=sc.nextInt();
            int score=dice.rollDice(numberOfDice);
            System.out.println(p1.getPlayerName()+" rolled a "+score+" on dice");
            score+=p1.getScore();
            System.out.println("current position of "+p1.getPlayerName()+" is "+score);
            System.out.println("****************************************");
            if(score>= playingBoard.getBoardSize()* playingBoard.getBoardSize()) {
                System.out.println("winner is "+p1.getPlayerName());
                return;
            }
            Cell cell = playingBoard.getCell(score);
            if(cell.getJump().getStart()==score) {
                if(cell.getJump().getStart()>cell.getJump().getEnd()) {
                    System.out.println("bitten by snake, moving from "+cell.getJump().getStart() +" to "+cell.getJump().getEnd());
                }
                if(cell.getJump().getStart()<cell.getJump().getEnd()) {
                    System.out.println("Climbing ladder, moving from "+cell.getJump().getStart() +" to "+cell.getJump().getEnd());
                }
                score=cell.getJump().getEnd();
            }
            p1.setScore(score);
            playerList.add(p1);
        }


    }

    Boolean isWinner() {
        for(Player p1: playerList) {
            int row=p1.getScore()/playingBoard.getBoardSize();
            int column=p1.getScore()%playingBoard.getBoardSize();
            if(row>playingBoard.getBoardSize() && column > playingBoard.getBoardSize()) {
                System.out.println("Game Over, Winner is "+p1.getPlayerName());
                return true;
            }
        }
        return false;
    }
}
