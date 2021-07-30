package javaBasics.abstractAndInterface;

//abstract class cannot be instanciated
abstract class TestAbstractClass {
    // defining an abtract class, no method implementation
    abstract void display();
    
    public int dataVal = 100;
     
    //An abstract class can have concrete method
    public int getDataVal() {
        System.out.println("return DataVal: " + dataVal);
        return this.dataVal;
    }
}
