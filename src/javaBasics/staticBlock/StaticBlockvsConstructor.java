package javaBasics.staticBlock;

import java.util.HashMap;
import java.util.Map;

public class StaticBlockvsConstructor {

    /**
     * static block vs constructor ref
     * https://study.com/academy/lesson/static-block-vs-constructor-in-java.html
     */
    static private String test = "test";
    static int staticCount = 0;
    int count = 0;
    public static final Map<String, String> initials = new HashMap<String, String>();

    static {
        //static block, run only once
        System.out.println("Hi, I'm a Static Block!" + StaticBlockvsConstructor.test + "Count: " + staticCount);
        // complex initialization
        initials.put("AEN", "Alfred E. Newman");
    }
    
      static void disp(){
      System.out.println("Hi, I'm a static display function!");
  }
      
       void func()
  {
      //Static method called in non-static method
      disp();
  }

      //static count is a static variable => Static variables are shared among all the instances of class
    public StaticBlockvsConstructor() {
        // the changes made to the static variable by object  will reflect in all the objects
        staticCount += 1;
        count += 1;
        System.out.println("Constructor 1 Says Hi! Count: " + count + ", staticCount: " + staticCount);
    }

    public StaticBlockvsConstructor(int c) {
        staticCount += 1;
        count += 1;
        System.out.println("Constructor 2 Says Hi! Count: " + count + ", staticCount: " + staticCount);
    }

    public static void main(String[] args) {
        //Static variables can be accessed directly , no need to create an instance to access a staic variable
        Map<String, String> map = StaticBlockvsConstructor.initials;
        System.out.println("map=>" + map);
        disp();
        //static count is class variable/count belongs to all the instance
        StaticBlockvsConstructor svc = new StaticBlockvsConstructor();
        // need to have object to call this non-static method
        svc.func();
        new StaticBlockvsConstructor(8);
        //call non-static nested static class
        StaticBlockvsConstructor.MyNestedClass staticNestedObj =  new StaticBlockvsConstructor.MyNestedClass();
        staticNestedObj.disp();
        //call static method in nested class
        MyNestedClass.staticDisp();
    }
        
    //Static class, nested class. A class can be made static only if it is a nested class
   static class MyNestedClass{
	//non-static method
	public void disp() {

	   /* If you make the staticCount variable of outer class
	    * non-static then you will get compilation error
	    * because: a nested static class cannot access non-
	    * static members (e.g. count) of the outer class.
	    */
	   System.out.println("Nested static class, disp method, static count: " + staticCount); 
	}
        
                   // static method
        	public static void staticDisp() {
	   System.out.println("Nested static class, static disp method, static count: " + staticCount); 
	}

   }
}
