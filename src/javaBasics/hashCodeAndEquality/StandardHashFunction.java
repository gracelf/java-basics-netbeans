package javaBasics.hashCodeAndEquality;

/**
 * https://www.baeldung.com/java-hashcode
 * explanation of hash code
 * hashing data structure  in Java https://www.geeksforgeeks.org/hashing-in-java/
 */
public class StandardHashFunction {

    private long id;
    private String name;
    private String email;

    // standard getters/setters/constructors
    
    // simple, degrades the function of Hashtable, as every object will be in same bucket
//    @Override
//    public int hashCode() {
//        return 1;
//    }
    @Override
    public int hashCode() {
        //use two prime numbers to add even more uniqueness to computed hash codes
        int hash = 7;
        hash = 31 * hash + (int) id;
        hash = 31 * hash + (name == null ? 0 : name.hashCode());
        hash = 31 * hash + (email == null ? 0 : email.hashCode());
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (this.getClass() != o.getClass()) {
            return false;
        }
        StandardHashFunction user = (StandardHashFunction) o;
        return id == user.id
                && (name.equals(user.name)
                && email.equals(user.email));
    }

    // getters and setters here
}
