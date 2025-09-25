package SOLIDPrinciplesPractice.LSP.shapes;

import SOLIDPrinciplesPractice.LSP.ShapesAreaCalculator;


public class circle extends ShapesAreaCalculator {

    private double radius;
    
    @Override
    public double CalculateArea() {
        return Math.PI * radius * radius;
    }
}
