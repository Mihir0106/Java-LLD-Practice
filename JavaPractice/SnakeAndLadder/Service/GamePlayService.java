package JavaPractice.SnakeAndLadder.Service;

import JavaPractice.SnakeAndLadder.Entity.Dice;
import JavaPractice.SnakeAndLadder.Entity.Player;
import JavaPractice.SnakeAndLadder.Enums.GamePlayStates;
import JavaPractice.SnakeAndLadder.GameBoard;
import JavaPractice.SnakeAndLadder.GamePlay;
import JavaPractice.SnakeAndLadder.Interface.ISnakeAndLadderGenerationStrategies;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class GamePlayService {
    List<Player> playerList;
    HashMap<Player,Boolean> playersPlaying;

    List<GamePlay> gamePlays = new LinkedList<>();

    public static GamePlayService instance;

    GamePlayService(){}

    public static GamePlayService getInstance() {
        if (instance == null) {
            instance = new GamePlayService();
        }
        return instance;
    }

    public void SetUpGame(GameBoard board, List<Player> playerList){
        GamePlay gamePlay = new GamePlay(board,playerList);
        gamePlays.add(gamePlay);

    }

    public void StartGame(){
        for(GamePlay gamePlay : gamePlays){
            if(gamePlay.getCurrestState() == GamePlayStates.ReadyToStart){
                gamePlay.StartGame();
            }
        }
    }
}
