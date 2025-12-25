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
    Map<Integer, Integer> playersStatus;
    GamePlayStates gamePlayState;

    public GamePlay(GameBoard board, List<Player> playerList) {
        this.gameBoard = board;
        this.dice = new Dice(1, 6);
        this.players = new LinkedList<>();
        playersStatus = new HashMap<>();
        PlayersTurnSetup(playerList);
        gamePlayState = GamePlayStates.ReadyToStart;

    }

    public GamePlayStates getCurrestState() {
        return gamePlayState;
    }

    public void PlayersTurnSetup(List<Player> playerList) {
        for (Player player : playerList) {
            players.offer(player);
            // initialPosition
            playersStatus.put(player.getUserId(), 0);
        }
    }

    public void StartGame() {
        gamePlayState = GamePlayStates.InProgress;
        while (gamePlayState == GamePlayStates.InProgress) {
            Player currentPlayer = players.poll();
            int currentPosition = playersStatus.get(currentPlayer.getUserId());
            int diceValue = dice.rollDice();
            int nextPosition = currentPosition + diceValue;

            if (nextPosition > gameBoard.board.WinningPoint()) {
                players.offer(currentPlayer);
                continue;
            }

            nextPosition = gameBoard.getNextPosition(nextPosition);
            playersStatus.put(currentPlayer.getUserId(), nextPosition);

            System.out.println(
                    "Player " + currentPlayer.getUsrName() + " rolled " + diceValue + " and moved to " + nextPosition);

            if (nextPosition == gameBoard.board.WinningPoint()) {
                gamePlayState = GamePlayStates.Completed;
                System.out.println("Player " + currentPlayer.getUsrName() + " Has Won the Game!");
                return;
            }

            players.offer(currentPlayer);
        }
    }

    boolean winCondition() {
        for (Map.Entry<Integer, Integer> player : playersStatus.entrySet()) {
            if (player.getValue() == gameBoard.board.WinningPoint()) {
                gamePlayState = GamePlayStates.Completed;
                return true;
            }
        }

        return false;
    }
}
