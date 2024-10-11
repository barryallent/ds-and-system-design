package org.example.LLD.Designs.TicTacToe;

import org.example.LLD.Designs.TicTacToe.Board.PlayingBoard;
import org.example.LLD.Designs.TicTacToe.Players.Player;
import org.example.LLD.Designs.TicTacToe.Players.PlayingPiece;

import java.util.List;
import java.util.Scanner;

public class PlayingClass {
    List<Player> players;

    PlayingBoard playingBoard;

    PlayingClass(int size, List<Player> players) {
        this.players=players;
        playingBoard=new PlayingBoard(size);
    }

    void play() {

        while(playingBoard.checkWinner().isWinner && playingBoard.isFreeSpaces()) {

            playingBoard.printBoard();
            Player p1 = players.get(0);
            players.remove(0);

            Boolean isPlaced=false;
            while (!isPlaced) {
                System.out.println("chance of "+p1.playerName+ " playing piece="+ p1.playingPiece);
                System.out.println("please choose row and column to place piece, space seperated");
                Scanner sc = new Scanner(System.in);
                String rowColumn = sc.nextLine();
                String[] input = rowColumn.split(" ");
                int row = Integer.parseInt(input[0]);
                int column = Integer.parseInt(input[1]);
                isPlaced = playingBoard.placePiece(row, column, p1.playingPiece);
                if(!isPlaced)  playingBoard.printBoard();
            }
            if(playingBoard.checkWinner().isWinner) {
                if(playingBoard.checkWinner().winner== PlayingPiece.X) {
                    for(Player p:players) {
                        if(p.playingPiece== PlayingPiece.X) {
                            System.out.println("winner is "+p.playerName);
                            return;
                        }
                    }
                }
                if(playingBoard.checkWinner().winner== PlayingPiece.O) {
                    for(Player p:players) {
                        if(p.playingPiece== PlayingPiece.O) {
                            System.out.println("winner is "+p.playerName);
                            return;
                        }
                    }
                }
            }
            players.add(p1);
        }
        System.out.println("Game over");

    }


}
