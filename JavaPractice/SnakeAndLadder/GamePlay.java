package JavaPractice.SnakeAndLadder;

import JavaPractice.SnakeAndLadder.Entity.Board;
import JavaPractice.SnakeAndLadder.Entity.Dice;
import JavaPractice.SnakeAndLadder.Entity.Player;
import JavaPractice.SnakeAndLadder.Enums.GamePlayStates;
import JavaPractice.SnakeAndLadder.Interface.ISnakeAndLadderGenerationStrategies;

import java.util.*;

public class GamePlay {

    // Responsible for Switch turn and Declare winner
    // keep track of Game
    Queue<Player> players;
    GameBoard gameBoard;
    Dice dice;
    Map<Integer,Integer> playersStatus;
    GamePlayStates gamePlayState;

    public GamePlay(GameBoard board, List<Player> playerList){
        this.gameBoard = board;
        this.dice = dice;
        this.players = new LinkedList<>();
        playersStatus = new HashMap<>();
        PlayersTurnSetup(playerList);
        gamePlayState = GamePlayStates.ReadyToStart;

    }

    public GamePlayStates getCurrestState() {
        return gamePlayState;
    }

    public void PlayersTurnSetup(List<Player> playerList){
        for(Player player : playerList){
            players.offer(player);
            // initialPosition
            playersStatus.put(player.getUserId(),0);
        }
    }

    public void StartGame(){
        gamePlayState = GamePlayStates.InProgress;
        while(!winCondition()){
            // WriteGame Play
            playersStatus.put(1, playersStatus.get(1) + 10);

            System.out.println("Game is running and current pos for 1st player is " + playersStatus.get(1));
        }
    }


    boolean winCondition(){
        for (Map.Entry<Integer,Integer> player : playersStatus.entrySet()){
            if(player.getValue() == gameBoard.board.WinningPoint()){
                gamePlayState = GamePlayStates.Completed;
                return true;
            }
        }

        return false;
    }
}
