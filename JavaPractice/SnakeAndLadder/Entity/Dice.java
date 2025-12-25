package JavaPractice.SnakeAndLadder.Entity;

import JavaPractice.SnakeAndLadder.Interface.IDice;

import java.util.Random;

public class Dice implements IDice {
    int minvalue;
    int maxValue;

    public Dice(int minvalue, int maxValue){
        this.minvalue = minvalue;
        this.maxValue = maxValue;
    }

    @Override
    public int rollDice(){
        return new Random().nextInt(minvalue,maxValue +1);
    }
}
