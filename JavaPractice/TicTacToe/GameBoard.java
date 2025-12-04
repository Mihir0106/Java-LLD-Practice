package JavaPractice.TicTacToe;

import JavaPractice.TicTacToe.PieceTypes.PieceType;
import JavaPractice.TicTacToe.PieceTypes.PlayingPiece;

import java.util.ArrayList;
import java.util.List;

public class GameBoard {
    PlayingPiece[][] board;
    int size;

    public GameBoard(int size){
        this.size = size;
        board = new PlayingPiece[size][size];
    }

    public Boolean addPiece(int row, int col, PlayingPiece piece){
        if(board[row][col] != null) return false;

        else board[row][col] = piece;
        return true;
    }

    public void printBoard(){
        // Print
    }

    public List<List<Integer>> freeSpots(){
        List<List<Integer>> listOfFreeSpotsIndex = new ArrayList<>();

        for(int i=0;i<size;i++){
            for (int j=0;j<size;j++){
               // if(board[i][j].Piecetype == PieceType.N){

               // }
            }
        }

        // Implmentation here can help

        return listOfFreeSpotsIndex;
    }



}
