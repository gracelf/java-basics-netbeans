package javaBasics.hashCodeAndEquality;

public class CrunchifyTest {

    /**
     * Reference Equality VS Logical Equality override equals() and hashcode()
     * in java; reference
     * https://crunchify.com/how-to-override-equals-and-hashcode-method-in-java/
     */
    public static void main(String[] args) {

        CrunchifyTest crunchifyTest = new CrunchifyTest();
        Crunchify one = new Crunchify(1);
        Crunchify two = new Crunchify(1);
        crunchifyTest.test1(one, two);

        Crunchify three = new Crunchify(1);
        Crunchify four = new Crunchify(2);
        crunchifyTest.test2(three, four);
    }

    public void test1(Crunchify one, Crunchify two) {
        if (one.equals(two)) {
            System.out.println("Test1: One and Two are equal");
        } else {
            System.out.println("Test1: One and Two are not equal");
        }
    }

    public void test2(Crunchify three, Crunchify four) {
        if (three.equals(four)) {
            System.out.println("Test2: Three and Four are equal");
        } else {
            System.out.println("Test2: Three and Four are not equal");
        }
    }
}
