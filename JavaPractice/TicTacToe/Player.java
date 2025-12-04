package JavaPractice.TicTacToe;

import JavaPractice.TicTacToe.PieceTypes.PieceType;
import JavaPractice.TicTacToe.PieceTypes.PlayingPiece;

public class Player {
    String name;
    PlayingPiece pieceType;

    public Player(String name,PlayingPiece pieceType){
        this.name = name;
        this.pieceType = pieceType;
    }

    public String getName() {
        return name;
    }

    public PlayingPiece getPieceType() {
        return pieceType;
    }

//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setPieceType(PlayingPiece pieceType) {
//        this.pieceType = pieceType;
//    }
}
