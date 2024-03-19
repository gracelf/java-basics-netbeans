package javaBasics.dataStructure;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class MapTest {

    public static void main(String[] args) {
        Map mapTest = new HashMap<String, String>();
        mapTest.put("A", "a test");
        mapTest.put("A", "a test2");
        System.out.println(mapTest.get("A"));
        //map.size() is 1
        System.out.println("map.size(): " +mapTest.size());
    }

}
