package JavaPractice.SnakeAndLadder;

import JavaPractice.SnakeAndLadder.Entity.Board;
import JavaPractice.SnakeAndLadder.Entity.BoardEntity;
import JavaPractice.SnakeAndLadder.Entity.Dice;
import JavaPractice.SnakeAndLadder.Interface.ISnakeAndLadderGenerationStrategies;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameBoard {
    Board board;
    List<BoardEntity> boardEntityList;
    ISnakeAndLadderGenerationStrategies snakeAndLadderGenerationStrategies;
    List<Integer> specialPoints;

    public GameBoard(Board board, int snakes, int ladders,ISnakeAndLadderGenerationStrategies snakeAndLadderGenerationStrategies){
        this.board = board;
        this.snakeAndLadderGenerationStrategies = snakeAndLadderGenerationStrategies;
        specialPoints = new ArrayList<>();
        boardEntityList = new ArrayList<>();

        GenerateSnakesAndLadders(snakes, ladders);
    }

    public void GenerateSnakesAndLadders(int s, int l){
        List<BoardEntity> snakes = snakeAndLadderGenerationStrategies.SnakeGeneration(s,specialPoints);
        boardEntityList.addAll(snakes);
        List<BoardEntity> ladder = snakeAndLadderGenerationStrategies.LadderGeneration(l,specialPoints);
        boardEntityList.addAll(ladder);

        boardEntityList.sort((a, b) -> a.getStart() - b.getStart());
    }
}
