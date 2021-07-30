

package lambdaAndfunctionInterfaceAndStream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 *
 * ref: https://www.geeksforgeeks.org/function-interface-in-java-with-examples/
 */
public class FunctionInterface {
    
    public static void main(String args[]) 
    {
        // Function which takes in a number Integer and returns Double (half of it) 
        Function<Integer, Double> half = a -> a / 2.0; 
        // second Function
        Function<Double, Double> treble = a -> a * 3; 
  
        // Now treble the output of half function 
        // 10/2 * 3 = 15; half function => a/2.0 * 3
        half = half.andThen(treble); 
        System.out.println(half.apply(10)); 
        
        //another way of the above func, treble again
        // 15*3 = 45; half function => a/2.0 * 3 * 3
        half = half.andThen(a -> a * 3); 
        System.out.println(half.apply(10)); 
        
        // compose(), It returns a composed function wherein the parameterized function will be executed FIRST and then the first one
        // (10+2)/2*3*3 = 54; half function => (a+2)/2.0 * 3 * 3
        half = half.compose(a -> a+2);
        System.out.println(half.apply(10));        
        
        //test with stream
        List<Type> typeList = new ArrayList<>();
        Function<Type, Label> typeToLabel = (Type t) -> {
            Label response = new Label();
            response.setLabel(t.getDescription());
            response.setValue(t.getDescription());
            return response;
        };
        
        Type type1 = new Type(1l, "Jeep");
        typeList.add(type1);
        Type type2 = new Type(2l, "Suv");
        typeList.add(type2);
        Type type3 = new Type(3l, "Sedan");
        typeList.add(type3);

        List<Label> returnedTypes =  typeList.stream().map(typeToLabel).collect(Collectors.toList());
        returnedTypes.forEach((returnedType) -> {
            System.out.println(returnedType.toString());
        });
       
        //fourth function => identify()
    }
}
