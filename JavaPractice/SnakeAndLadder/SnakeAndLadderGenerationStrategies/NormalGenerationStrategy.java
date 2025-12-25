package JavaPractice.SnakeAndLadder.SnakeAndLadderGenerationStrategies;

import JavaPractice.SnakeAndLadder.Entity.Board;
import JavaPractice.SnakeAndLadder.Entity.BoardEntity;
import JavaPractice.SnakeAndLadder.Interface.ISnakeAndLadderGenerationStrategies;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class NormalGenerationStrategy implements ISnakeAndLadderGenerationStrategies {
    Board board;

    public NormalGenerationStrategy(Board board) {
        this.board = board;
    }

    @Override
    public List<BoardEntity> SnakeGeneration(int n, List<Integer> alreadyMarked) {
        List<BoardEntity> snakes = new ArrayList<>();
        Random random = new Random();
        int attempt = 0;
        int max = board.WinningPoint();

        while (snakes.size() < n && attempt < 1000) {
            int start = random.nextInt(max - 1) + 1; // 1 to max-1
            int end = random.nextInt(max - 1) + 1;

            if (start <= end) {
                continue; // Snake must go down
            }
            if (alreadyMarked.contains(start) || alreadyMarked.contains(end)) {
                continue;
            }

            alreadyMarked.add(start);
            alreadyMarked.add(end);
            snakes.add(new BoardEntity(start, end));
        }
        return snakes;
    }

    @Override
    public List<BoardEntity> LadderGeneration(int n, List<Integer> alreadyMarked) {
        List<BoardEntity> ladders = new ArrayList<>();
        Random random = new Random();
        int attempt = 0;
        int max = board.WinningPoint();

        while (ladders.size() < n && attempt < 1000) {
            int start = random.nextInt(max - 1) + 1;
            int end = random.nextInt(max - 1) + 1;

            if (start >= end) {
                continue; // Ladder must go up
            }
            if (alreadyMarked.contains(start) || alreadyMarked.contains(end)) {
                continue;
            }

            alreadyMarked.add(start);
            alreadyMarked.add(end);
            ladders.add(new BoardEntity(start, end));
        }
        return ladders;
    }
}
