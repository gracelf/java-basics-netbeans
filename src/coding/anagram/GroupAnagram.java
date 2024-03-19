package coding.anagram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/group-anagrams/ Input: strs =
 * ["eat","tea","tan","ate","nat","bat"] Output:
 * [["bat"],["nat","tan"],["ate","eat","tea"]] other solutions:
 * https://leetcode.com/problems/group-anagrams/discuss/250264/Java-Solutions
 */
public class GroupAnagram {

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            ///String sorted_string = new String(chars);
            //less storage than above
            String sorted_string = String.valueOf(chars);
//            if (map.containsKey(sorted_string)) {
//                map.get(sorted_string).add(str);
//            } else {
//                ArrayList<String> tempList = new ArrayList<>();
//                tempList.add(str);
//                map.put(sorted_string, tempList);
//            }
            map.putIfAbsent(sorted_string, new ArrayList<>());
            map.get(sorted_string).add(str);

        }
        if (map.values() != null) {
            list = new ArrayList<>(map.values());
        }

        return list;

    }

    public static void displayList(List<List<String>> list) {
        for (List<String> element : list) {
            System.out.print("[");
            for (String str : element) {
                System.out.print(str + ",");
            }
            System.out.println("]");
        }
    }

    public List<List<String>> groupAnagramsSimplified(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            // map method: computeIfAbsent
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
            // same as follows
            map.putIfAbsent(key, new ArrayList<>());		// If no mapping for a key, then map a new key with an empty list.
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagrams(strs);
        displayList(result);

        String[] strs2 = new String[]{};
        List<List<String>> result2 = groupAnagrams(strs2);
        displayList(result2);

    }
}
