package org.example.LLD.Designs.TicTacToe.Players;

public class Winner {
    public Boolean isWinner;
    public PlayingPiece winner;

    public Winner(Boolean isWinner, PlayingPiece winner) {
        this.winner=winner;
        this.isWinner=isWinner;
    }
}
