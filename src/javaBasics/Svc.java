package javaBasics;

import java.util.HashMap;
import java.util.Map;

public class Svc {

    /**
     *
     */
    static private String test = "test";
    public static final Map<String, String> initials = new HashMap<String, String>();
    

    static {
        //static block
        System.out.println("Hi, I'm a Static Block!" + Svc.test);
        // complex initialization
        initials.put("AEN", "Alfred E. Newman");
    }

    public Svc() {
        System.out.println("Constructor 1 Says Hi!");
    }

    public Svc(int c) {
        System.out.println("Constructor 2 Says Hi!");
    }
}
