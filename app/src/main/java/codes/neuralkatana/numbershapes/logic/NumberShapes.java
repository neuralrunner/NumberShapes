package codes.neuralkatana.numbershapes.logic;

public class NumberShapes {
    private int number;

    public NumberShapes(int n){
        number = n;
    }

    public boolean isTriangular(){
        double val = (Math.sqrt(8 * number + 1) - 1) / 2;
        return val % 1 == 0;
    }

    public boolean isSquare(){
        for (int i = 0; i < number / 2 + 2; i++){
            if (i * i == number){
                return true;
            }
        }
        return false;
    }
}
