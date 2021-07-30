package hashSetVsHashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * ref: https://www.w3schools.com/java/java_hashmap.asp
 * https://www.geeksforgeeks.org/java-util-hashmap-in-java-with-examples/
 * https://beginnersbook.com/2013/12/hashmap-in-java-with-example/
 * hashmap is not synchronized, an ordered collection, and is serialized by default 
 *
 */
public class HashMapExamples {

    public static void main(String[] args) {
        // Create a HashMap object called capitalCities, intial size 3, can be increated (put more than 3 object is fine)
        HashMap<String, String> capitalCities = new HashMap<>(3);

        // Add keys and values (Country, City)
        //HashMap doesn’t allow duplicate keys but allows duplicate values.
        capitalCities.put("England", "London");
        capitalCities.put("Germany", "Berlin");
        capitalCities.put("Norway", "Oslo");
        capitalCities.put("USA", "Washington DC");
        //allows one key to be null
        capitalCities.put(null, "default");
        //allows multiple value to be null
        capitalCities.put("UN", null);
        System.out.println(capitalCities);

        capitalCities.keySet().forEach((country) -> {
            //even when the key is null, the key/value pair will display 
            System.out.println(country);
        });

        capitalCities.values().forEach((cities) -> {
            System.out.println(cities);
        });

        capitalCities.keySet().forEach((country) -> {
            System.out.println("country: " + country + ", capital city: " + capitalCities.get(country));
        });

        Set set = capitalCities.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            System.out.print("key is: " + mentry.getKey() + " & Value is: ");
            System.out.println(mentry.getValue());
        }
    }

}
