package lambdaAndfunctionInterfaceAndStream;

import java.util.ArrayList;

/**
 * @author grace.fu
 * https://github.com/DharmendraRathor/horizon/blob/master/java8feature/src/main/java/com/dsr/java/java8feature/LambdaExample.java
 * 
 */
public class LambdaAndFunctional {

    public static void main(String args[]) {

        // lambda expression with no input paramter
        new Thread(
                () -> {
                    System.out.println("New thread created");
                }).start();

        //lambda experession with input
        ArrayList<String> cities = new ArrayList<>();
        cities.add("Washing, D.C.");
        cities.add("Seatle");
        cities.forEach((city) -> {
            System.out.println(city);
        });

        //BlockLambdaExpression in a funtional interface, impletmet the abstact method in the interface
        // in this case, lambdaExpression implements abstract double findSquareRoot(int n) method in FunctionalInterfaceTest Class
        FunctionalInterfaceTest squareRoot1 = (n) -> {
            double result = Math.sqrt(n);
            return result;
        };
        System.out.println("squareRoot: " + squareRoot1.findSquareRoot(9));

        //LambdaAsArgument
        FunctionalInterfaceTest squareRoot2 = (n) -> (Math.sqrt(n));

        //LambdaExpressionWithType
        FunctionalInterfaceTest squareRoot3 = (int n) -> (Math.sqrt(n));

    }
}
