package coding.miscellaneous;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 *
 */
public class TestingBasics {
    
    public static void main(String[] args) {
        int x = 5678;
        String y = "testtre";

        char[] nums = String.valueOf(x).toCharArray();
        int i = nums.length;
        String str = String.valueOf(x);
        str.length();

        ArrayList<String> cars = new ArrayList<String>();
        cars.add("Rav4");
        // arraylist to array
        Object[] strs = cars.toArray();
        
        System.out.println("Testing Result: " + strs[0]);

    }

}
