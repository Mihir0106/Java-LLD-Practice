package JavaPractice.SnakeAndLadder.Entity;

import JavaPractice.SnakeAndLadder.Enums.BoardEntityType;

public class BoardEntity {
    int start;
    int end;
    BoardEntityType type;

    public BoardEntity(int start, int end){
        this.start = start;
        this.end = end;
        type = (start > end) ? BoardEntityType.Snake : BoardEntityType.Ladder;
    }

    public int getStart(){
        return start;
    }

}
