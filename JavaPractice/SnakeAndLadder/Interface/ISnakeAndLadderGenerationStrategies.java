package JavaPractice.SnakeAndLadder.Interface;

import JavaPractice.SnakeAndLadder.Entity.BoardEntity;

import java.util.List;

public interface ISnakeAndLadderGenerationStrategies {

    public List<BoardEntity> SnakeGeneration(int n, List<Integer> alreadyMarked);

    public List<BoardEntity> LadderGeneration(int n,List<Integer> alreadyMarked);

}
