package hashSetVsHashMap;

/**
 * ref:
 * https://beginnersbook.com/2013/12/how-to-synchronize-hashmap-in-java-with-example/
 */
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;

public class HashMapSyncExample {

    public static void main(String args[]) {
        HashMap<Integer, String> hmap = new HashMap<Integer, String>();
        hmap.put(1, "London");
        hmap.put(2, "Berlin");
        hmap.put(3, "Oslo");
        hmap.put(4, "Washington DC");

        Map map = Collections.synchronizedMap(hmap);
        Set set = map.entrySet();
        synchronized (map) {
            //Iterator needs to be in sync block
            Iterator i = set.iterator();
            // Display elements
            while (i.hasNext()) {
                Map.Entry me = (Map.Entry) i.next();
                System.out.print(me.getKey() + ": ");
                System.out.println(me.getValue());
            }
        }
    }
}
