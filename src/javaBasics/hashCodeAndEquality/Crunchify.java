package javaBasics.hashCodeAndEquality;

public class Crunchify {

    private int value;

    Crunchify(int val) {
        value = val;
    }

    public int getValue() {
        return value;
    }

    // The method does override or implement a method declared in a supertype.
    @Override
    public boolean equals(Object o) {

        // null check
        if (o == null) {
            return false;
        }

        // compare instance o to "this" instance, check reference equality
        if (this == o) {
            return true;
        } 
//       checking reference equality       
//        else {
//        return  false;
//        }
        
        //checking logical equality => instanceof Check and actual value check, replace this block with 
        if ((o instanceof Crunchify) && (((Crunchify) o).getValue() == this.value)) {
            return true;
        } else {
            return false;
        }
    }

//HashCode and equals are closely related :
//1) if you override equals, you MUST override hashCode.
//2) hashCode must generate equal values for equal objects.
//3) equals and hashCode must depend on the same set of significant fields. You must use the same set of fields in both of these methods. You are not required to use all fields. 
//For example, a calculated field that depends on others should very likely be omitted from equals and hashCode.
    @Override
    public int hashCode() {
        int result = 0;
        result = (int) (value / 11);
        return result;
    }

}
