package org.example.LLD.Designs.TicTacToe.Board;

import org.example.LLD.Designs.TicTacToe.Players.Winner;
import org.example.LLD.Designs.TicTacToe.Players.PlayingPiece;

public class PlayingBoard {

    PlayingPiece[][] board;
    int size;
    public PlayingBoard(int size) {
        this.size=size;
        board=new PlayingPiece[size][size];
    }

    public void printBoard() {
        System.out.println("****************************************************************");
        for(int i=0;i<size;i++) {
            for (int j=0;j<size;j++) {
                if(board[i][j]==null) {
                    System.out.print("_ ");
                }
                else{
                    System.out.print(board[i][j]+" ");
                }

            }
            System.out.println();
        }
        System.out.println("****************************************************************");
    }

    public Winner checkWinner() {
        // Horizontal check
        for (int i = 0; i < size; i++) {
            boolean winnerFound = true;
            PlayingPiece winnerPiece = board[i][0];
            if (winnerPiece == null) continue;
            for (int j = 1; j < size; j++) {
                if (board[i][j] != winnerPiece) {
                    winnerFound = false;
                    break;
                }
            }
            if (winnerFound) {
                return new Winner(true, winnerPiece);
            }
        }

        // Vertical check
        for (int j = 0; j < size; j++) {
            boolean winnerFound = true;
            PlayingPiece winnerPiece = board[0][j];
            if (winnerPiece == null) continue;
            for (int i = 1; i < size; i++) {
                if (board[i][j] != winnerPiece) {
                    winnerFound = false;
                    break;
                }
            }
            if (winnerFound) {
                return new Winner(true, winnerPiece);
            }
        }

        // Diagonal check (top-left to bottom-right)
        boolean winnerFound = true;
        PlayingPiece winnerPiece = board[0][0];
        // Check if diagonal starts with a non-empty piece
        if (winnerPiece != null) {
            for (int i = 1; i < size; i++) {
                if (board[i][i] != winnerPiece) {
                    winnerFound = false;
                    break;
                }
            }
            if (winnerFound) {
                return new Winner(true, winnerPiece);
            }
        }

        // Diagonal check (top-right to bottom-left)
        winnerFound = true;
        winnerPiece = board[0][size - 1];
        // Check if diagonal starts with a non-empty piece
        if (winnerPiece != null) {
            for (int i = 1; i < size; i++) {
                if (board[i][size - 1 - i] != winnerPiece) {
                    winnerFound = false;
                    break;
                }
            }
            if (winnerFound) {
                return new Winner(true, winnerPiece);
            }
        }

        // No winner found
        return new Winner(false, null);
    }

    public Boolean placePiece(int row, int column, PlayingPiece playingPiece) {
        if(row>=size || column>=size) {
            System.out.println("please choose correct length, please try again");
            return false;
        }
        if(board[row][column]!=null) {
            System.out.println("this is a non empty position, please try other position");
            return false;
        }
        board[row][column] = playingPiece;
        return true;
    }

    public Boolean isFreeSpaces() {
        for(int i=0;i<size;i++) {
            for(int j=0;j<size;j++) {
                if(board[i][j]==null) {
                    return true;
                }
            }
        }
        return false;
    }

}
