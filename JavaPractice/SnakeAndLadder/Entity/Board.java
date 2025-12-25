package JavaPractice.SnakeAndLadder.Entity;

import JavaPractice.SnakeAndLadder.Enums.BoardEntityType;

import java.util.ArrayList;
import java.util.List;

public class Board {
    int maxPoint;

    public Board(int n ){
        maxPoint = n*n;
    }

    public int WinningPoint(){
        return maxPoint;
    }
}
