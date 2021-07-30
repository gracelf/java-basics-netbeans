package javaBasics.hashCodeAndEquality;

public class TestEquality {

    public static void main(String[] args) {
        String strA = new String("eBay");
        String strB = new String("eBay");
        String strC = new String("Paypal");
        String strD = new String("amazon");

        // Create a String reference and assign an existing String's reference to it
        // so that both references point to the same String object in memory.
        strD = strA;

        // Print out the results of various equality checks
        // Reference Equality
        System.out.println("Reference Equality Result:");
        System.out.println(strA == strB);
        System.out.println(strA == strC);
        System.out.println(strA == strD);
        strA = "Venmo";
        //  strD still points to same object in memory, still prints eBay
        System.out.println(strD);
        System.out.println(strA);
        strA = strC;
        // strD still points to same object in memory, still prints eBay
        System.out.println(strD);
        System.out.println(strA);
        strD = strB;
        System.out.println(strD);
        System.out.println(strA);

        // Logical Equality
        System.out.println("\nLogical Equality Result:");
        System.out.println(strA.equals(strB));
        System.out.println(strA.equals(strC));
        System.out.println(strA.equals(strD));
    }
}
