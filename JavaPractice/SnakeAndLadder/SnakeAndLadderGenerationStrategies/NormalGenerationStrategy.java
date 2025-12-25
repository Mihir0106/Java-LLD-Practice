package JavaPractice.SnakeAndLadder.SnakeAndLadderGenerationStrategies;

import JavaPractice.SnakeAndLadder.Entity.Board;
import JavaPractice.SnakeAndLadder.Entity.BoardEntity;
import JavaPractice.SnakeAndLadder.Interface.ISnakeAndLadderGenerationStrategies;

import java.util.List;

public class NormalGenerationStrategy implements ISnakeAndLadderGenerationStrategies {
    Board board;

    public NormalGenerationStrategy(Board board){
        this.board = board;
    }


    @Override
    public List<BoardEntity> SnakeGeneration(int n, List<Integer> alreadyMarked) {

        return List.of();
    }

    @Override
    public List<BoardEntity> LadderGeneration(int n, List<Integer> alreadyMarked) {
        return List.of();
    }
}
