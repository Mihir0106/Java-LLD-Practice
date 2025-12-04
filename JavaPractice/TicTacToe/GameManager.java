package JavaPractice.TicTacToe;

import JavaPractice.TicTacToe.PieceTypes.PlayingPieceO;
import JavaPractice.TicTacToe.PieceTypes.PlayingPieceX;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class GameManager {
    Deque<Player> players;
    GameBoard gameBoard;

    public void InitialiseGame(){
        gameBoard = new GameBoard(3);

        Player player1 = new Player("Mihir", new PlayingPieceX());
        Player player2 = new Player("Mumpy", new PlayingPieceO());

        players = new LinkedList<>();
        players.add(player1);
        players.add(player2);
    }

    public void StartGame(){
        boolean isWinner = false;
        while(!isWinner){
            Player turnPlayer = players.poll();
            assert turnPlayer != null;
            System.out.println("your Turn" + turnPlayer.getName());
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter row and col");
            int row = sc.nextInt();
            int col = sc.nextInt();

            boolean addOperation = gameBoard.addPiece(row,col, turnPlayer.getPieceType());

            if(CheckForWinner()){
                isWinner = true;
            }

            players.offer(turnPlayer);

        }

    }

    boolean CheckForWinner(){
        return true;
    }



}
