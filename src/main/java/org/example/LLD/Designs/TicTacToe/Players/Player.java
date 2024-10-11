package org.example.LLD.Designs.TicTacToe.Players;

public class Player {
    public PlayingPiece playingPiece;
    public String playerName;
    public Player(PlayingPiece playingPiece, String playerName) {
        this.playingPiece=playingPiece;
        this.playerName=playerName;
    }
}
