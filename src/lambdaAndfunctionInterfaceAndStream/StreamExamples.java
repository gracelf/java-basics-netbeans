

package lambdaAndfunctionInterfaceAndStream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 *
 * @author grace.fu
 */
public class StreamExamples {
    
    public static void main(String args[]){
        //stream with functional interface
        List<Type> typeList = new ArrayList<>();
        Function<Type, Label> typeToDropdown = (Type t) -> {
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

        List<Label> returnedTypes =  typeList.stream().map(typeToDropdown).collect(Collectors.toList());
        returnedTypes.forEach((returnedType) -> {
            System.out.println(returnedType.toString());
        });
    
    }

}
