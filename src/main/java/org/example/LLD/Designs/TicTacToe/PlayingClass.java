package org.example.LLD.Designs.TicTacToe;

import org.example.LLD.Designs.TicTacToe.Board.PlayingBoard;
import org.example.LLD.Designs.TicTacToe.Players.Player;
import org.example.LLD.Designs.TicTacToe.Players.PlayingPiece;
import org.example.LLD.Designs.TicTacToe.Players.Winner;

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
        Scanner sc = new Scanner(System.in);

        while (true) {
            // Print the board at the start of each round
            playingBoard.printBoard();

            // Check for winner or tie at the start of each loop iteration
            Winner winnerResult = playingBoard.checkWinner();
            if (winnerResult.isWinner) {
                System.out.println("Winner is " + winnerResult.winner);
                break;
            }

            if (!playingBoard.isFreeSpaces()) {
                System.out.println("Game over - It's a tie!");
                break;
            }

            // Get the current player
            Player currentPlayer = players.get(0);
            System.out.println("Turn: " + currentPlayer.playerName + " playing piece = " + currentPlayer.playingPiece);

            // Try to place the piece until a valid position is chosen
            boolean isPlaced = false;
            while (!isPlaced) {
                System.out.println("Choose row and column to place piece, separated by a space:");
                String rowColumn = sc.nextLine();
                String[] input = rowColumn.trim().split(" ");
                if (input.length != 2) {
                    System.out.println("Invalid input. Please enter two numbers separated by space.");
                    continue;
                }

                try {
                    int row = Integer.parseInt(input[0]);
                    int column = Integer.parseInt(input[1]);
                    isPlaced = playingBoard.placePiece(row, column, currentPlayer.playingPiece);
                    if (!isPlaced) {
                        System.out.println("Position already occupied, try another.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter numeric values.");
                }
            }

            // Rotate players
            players.add(players.remove(0));
        }

        sc.close();
    }


}
