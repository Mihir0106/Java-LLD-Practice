package JavaPractice.SnakeAndLadder;

import JavaPractice.SnakeAndLadder.Entity.Board;
import JavaPractice.SnakeAndLadder.Entity.BoardEntity;
import JavaPractice.SnakeAndLadder.Entity.Dice;
import JavaPractice.SnakeAndLadder.Interface.ISnakeAndLadderGenerationStrategies;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class GameBoard {
    Board board;
    List<BoardEntity> boardEntityList;
    ISnakeAndLadderGenerationStrategies snakeAndLadderGenerationStrategies;
    List<Integer> specialPoints;
    Map<Integer, Integer> jumpMap;

    public GameBoard(Board board, int snakes, int ladders,
            ISnakeAndLadderGenerationStrategies snakeAndLadderGenerationStrategies) {
        this.board = board;
        this.snakeAndLadderGenerationStrategies = snakeAndLadderGenerationStrategies;
        specialPoints = new ArrayList<>();
        boardEntityList = new ArrayList<>();
        jumpMap = new HashMap<>();

        GenerateSnakesAndLadders(snakes, ladders);
    }

    public void GenerateSnakesAndLadders(int s, int l) {
        List<BoardEntity> snakes = snakeAndLadderGenerationStrategies.SnakeGeneration(s, specialPoints);
        boardEntityList.addAll(snakes);
        List<BoardEntity> ladder = snakeAndLadderGenerationStrategies.LadderGeneration(l, specialPoints);
        boardEntityList.addAll(ladder);

        boardEntityList.sort((a, b) -> a.getStart() - b.getStart());

        // Populate fast lookup map
        for (BoardEntity entity : boardEntityList) {
            jumpMap.put(entity.getStart(), entity.getEnd());
        }
    }

    public int getNextPosition(int pos) {
        if (pos > board.WinningPoint()) {
            return pos;
        }
        if (jumpMap.containsKey(pos)) {
            System.out.println("Jump at " + pos + " to " + jumpMap.get(pos));
            return jumpMap.get(pos);
        }
        return pos;
    }

    public int getNextIndex(int num) {
        // Write logic for lookup and then return
        // if key Exist in the KeyValue pair then return value or else return same value
        return num;
    }
}
