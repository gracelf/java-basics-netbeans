package hashSetVsHashMap;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 */
public class HashSetExample {

    public static void main(String args[]) {
        int a[] = {77, 23, 4, 66, 99, 112, 45, 56, 39, 89};
        Set<Integer> s = new HashSet<>();
        try {
            for (int i = 0; i < 5; i++) {
                s.add(a[i]);
            }
            System.out.println(s);
            //Tree set are sorted
            TreeSet sorted = new TreeSet<>(s);
            System.out.println("Sorted list = ");
            System.out.println(sorted);
        } catch (Exception e) {
        }
    }

}
