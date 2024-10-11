package org.example.LLD.Designs.SnakesAndLadders.PlayingBoard;

import lombok.Data;

import java.util.Random;

@Data
public class PlayingBoard {
    Cell[][] board;
    int boardSize;

    public PlayingBoard(int size) {
        this.boardSize=size;
        board=new Cell[size][size];
        initializeCells();
    }

    private void initializeCells() {
        for(int i=0;i<boardSize;i++) {
            for(int j=0; j<boardSize;j++) {
                Jump jump = new Jump(0,0);
                Cell cellObj = new Cell(jump);
                board[i][j] = cellObj;
            }
        }
    }
    public void initializeSnakeAndLadders(int numberOfSnakes, int numberOfLadders) {
        Random r1 = new Random();
        while(numberOfSnakes>0) {
            int snakeStart=r1.nextInt(1,(boardSize*boardSize)-1);
            int snakeEnd=r1.nextInt(1,(boardSize*boardSize)-1);
            if(snakeStart<=snakeEnd) {
                continue;
            }
            else{
                Jump jump = new Jump(snakeStart,snakeEnd);
                System.out.println("placed snake at "+snakeStart+" "+snakeEnd);
                Cell cell = getCell(snakeStart);
                cell.jump=jump;
                numberOfSnakes--;
            }
        }
        while(numberOfLadders>0) {
            int ladderStart=r1.nextInt(1,(boardSize*boardSize)-1);
            int ladderEnd=r1.nextInt(1,(boardSize*boardSize)-1);
            if(ladderStart>=ladderEnd) {
                continue;
            }
            else{
                Jump jump = new Jump(ladderStart,ladderEnd);
                System.out.println("placed ladder at "+ladderStart+" "+ladderEnd);
                Cell cell = getCell(ladderStart);
                cell.jump=jump;
                numberOfLadders--;
            }
        }
    }


    public Cell getCell(int currentPosition) {
        int row=currentPosition/boardSize;
        int column=currentPosition%boardSize;
        return board[row][column];
    }

}
