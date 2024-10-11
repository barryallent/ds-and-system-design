package org.example.LLD.Designs.TicTacToe;

import org.example.LLD.Designs.TicTacToe.Players.Player;
import org.example.LLD.Designs.TicTacToe.Players.PlayingPiece;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        Player p1 = new Player(PlayingPiece.X,"player1");
        Player p2 = new Player(PlayingPiece.O,"player2");
        List<Player> players = new ArrayList<>();
        players.add(p1);
        players.add(p2);
        PlayingClass playingClass = new PlayingClass(3,players);

        //not fully accurate, calculate winner function is not right
        playingClass.play();
    }
}
