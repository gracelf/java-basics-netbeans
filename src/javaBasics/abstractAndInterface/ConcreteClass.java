package javaBasics.abstractAndInterface;

//must implement all the methods from interfaces and implement all abstact method
public class ConcreteClass extends TestAbstractClass implements TestInterface, TestInterface2 {

    @Override
    public void display() {
        System.out.println("test abstract class");
    }

    @Override
    public void testInterface() {
        System.out.println("have to override the abstract method in test interface ");
    }

    @Override
    public void testInterface2() {
        System.out.println("have to override the abstract method in test interface 2");
    }

    public void testConcreate() {
        System.out.println("test interface 2");
    }

    public static void main(String[] args) {
        //initialize an abstract instance
        TestAbstractClass ab = new ConcreteClass();
        //initialize an interface
        TestInterface ti = new ConcreteClass();
        ConcreteClass con = new ConcreteClass();
        // method for ab object
        ab.display();
        ab.getDataVal();
        // ab.testInterface();

        // method available for ti object
        // can't do ti.display();
        ti.testInterface();

        //method for con object, all methods are available
        con.display();
        con.getDataVal();
        con.testInterface();
        con.testInterface2();

    }
}
