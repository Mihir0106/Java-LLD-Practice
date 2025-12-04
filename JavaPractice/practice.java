package JavaPractice;


import JavaPractice.TicTacToe.GameManager;
import JavaPractice.helloworld.handyClass;

public class practice {
    public static void main(String[] args){
        //handyClass.helloWorld();
        GameManager gameManager = new GameManager();
        gameManager.InitialiseGame();
        gameManager.StartGame();

    }
}
