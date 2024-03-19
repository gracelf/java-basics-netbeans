package hashSetVsHashMap;

/**
 *
 */
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ExceptionExample {

    public static void main(String[] args) {
        Map<String, Long> phoneBook = new HashMap<String, Long>();
        phoneBook.put("Vikram", 8149101254L);
        phoneBook.put("Mike", 9020341211L);
        phoneBook.put("Jim", 7788111284L);

        Iterator<String> keyIterator = phoneBook.keySet().iterator();

        while (keyIterator.hasNext()) {
            String key = keyIterator.next();
            System.out.println("key: " + key);
            if ("Vikram".equals(key)) {
                //modify the Hashmap will cause "ConcurrentModificationException"
                //phoneBook.put("John",9220341211L);
                //ok to modify the keyIterator. This updates the underlying map and the iterator’s state that refers to the internals of the map
                keyIterator.remove();
                //phoneBook.remove("Vikram");

            }
            System.out.println(key + ": " + phoneBook.get(key));
        }
        //after above remove, the size becomes 2. "Vikram" pair is removed!
        System.out.println("size: " + phoneBook.size());
        displayHashmap(phoneBook);
    }

    public static void displayHashmap(Map<String, Long> book) {
        Iterator<String> keyIterator = book.keySet().iterator();
        System.out.println("Displaying the hashmap");
        while (keyIterator.hasNext()) {
            String key = keyIterator.next();
            System.out.println(key + ": " + book.get(key));

        }

    }
}
