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
        //match horizontally
        for(int i=0;i<size;i++) {
            Boolean winnerFound=true;
            PlayingPiece winnerPiece=null;
            for(int j=0;j<size-1;j++) {
                if(board[i][j]==board[i][j+1]) {
                    winnerPiece=board[i][j];
                }
                else {
                    winnerFound=false;
                }
            }
            if(winnerFound) {
                return new Winner(true,winnerPiece);
            }
        }

        //match vertically
        for(int j=0;j<size;j++) {
            Boolean winnerFound=true;
            PlayingPiece winnerPiece=null;
            for(int i=0;i<size-1;i++) {
                if(board[i][j]==board[i+1][j]) {
                    winnerPiece=board[i][j];
                }
                else {
                    winnerFound=false;
                }
            }
            if(winnerFound) {
                System.out.println("winner is found, winner is"+ winnerPiece);
                return new Winner(true,winnerPiece);
            }
        }

        return new Winner(false,null);
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
