package JavaPractice;

import JavaPractice.helloworld.handyClass;
import SOLIDPrinciplesPractice.LSP.ShapesAreaCalculator;
import SOLIDPrinciplesPractice.LSP.shapes.circle;

public class practice {
    public static void main(String[] args){
//        handyClass.helloWorld();
       // circle
        ShapesAreaCalculator calculator = new circle();
        System.out.println("Area " + calculator.CalculateArea());
    }
}
