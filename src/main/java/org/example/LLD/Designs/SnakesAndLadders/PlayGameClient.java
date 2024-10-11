package org.example.LLD.Designs.SnakesAndLadders;

import org.example.LLD.Designs.SnakesAndLadders.Game.SnakeAndLaddersGame;
import org.example.LLD.Designs.SnakesAndLadders.Player.Player;
import org.example.LLD.Designs.SnakesAndLadders.PlayingBoard.PlayingBoard;

import java.util.ArrayList;
import java.util.List;

public class PlayGameClient {
    public static void main(String[] args) throws InterruptedException {
        PlayingBoard playingBoard = new PlayingBoard(10);
        Player p1 = new Player("player1","1",0);
        Player p2 = new Player("player2","2",0);
        List<Player> playerList= new ArrayList<>();
        playerList.add(p1);
        playerList.add(p2);
        SnakeAndLaddersGame snakeAndLaddersGame = new SnakeAndLaddersGame(playerList,playingBoard,7,5,1);
        snakeAndLaddersGame.playGame();
    }
}
