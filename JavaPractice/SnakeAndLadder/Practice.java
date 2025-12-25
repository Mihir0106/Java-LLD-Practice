package JavaPractice.SnakeAndLadder;

import JavaPractice.SnakeAndLadder.Entity.Board;
import JavaPractice.SnakeAndLadder.Entity.Dice;
import JavaPractice.SnakeAndLadder.Entity.Player;
import JavaPractice.SnakeAndLadder.Interface.ISnakeAndLadderGenerationStrategies;
import JavaPractice.SnakeAndLadder.Service.GamePlayService;
import JavaPractice.SnakeAndLadder.SnakeAndLadderGenerationStrategies.NormalGenerationStrategy;

import java.util.ArrayList;
import java.util.List;

public class Practice {
    static void main() {
        Player player1 = new Player(1,"Mihir");
        Player player2 = new Player(2,"Jain");
        List<Player> playerList = new ArrayList<>();
        playerList.add(player1);
        playerList.add(player2);

        int size = 10;
        int snakes = 6;
        int ladder = 5;
        Board board = new Board(10);
        Dice dice = new Dice(1,6);
        ISnakeAndLadderGenerationStrategies  snakeAndLadderGenerationStrategies = new NormalGenerationStrategy(board);
        GameBoard gameBoard = new GameBoard(board,snakes,ladder,snakeAndLadderGenerationStrategies);


        GamePlayService.getInstance().SetUpGame(gameBoard,playerList);
        GamePlayService.getInstance().StartGame();


    }

    // Player 1
    // Player 2
    // Board
    // Generate snake and Ladders
    // Create Game : List Players, Board
    // StartGame
}
