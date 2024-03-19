package coding.anagram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class FindAllAnagramInString {

    public static List<Integer> find(String s, String p) {
        ArrayList<Integer> result = new ArrayList<>();
        int length = p.length();
        for (int i = 0; i + length <= s.length(); i++) {
            String temp = s.substring(i, i + length);
            if (isAnagram(temp, p)) {
                result.add(i);
            }
        }
        return result;

    }

    public static boolean isAnagram(String a, String b) {
        char[] charA = a.toCharArray();
        Arrays.sort(charA);
        char[] charB = b.toCharArray();
        Arrays.sort(charB);
        if (Arrays.equals(charA, charB)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> result = find(s, p);
        displayList(result);
    }

    public static void displayList(List<Integer> list) {

        System.out.print("[");
        for (Integer element : list) {
            System.out.print(element + ",");
        }
        System.out.println("]");
    }
    
    

}
