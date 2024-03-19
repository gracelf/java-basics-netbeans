

package coding.longestSubstring;

/**
 *
 */
public class LongestSubstringPrefix {
        public static String longestSubstringPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        //assume the first string is the longest substring prefix
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                //decrease the prefix size by getting rid of the last letter)
                prefix = prefix.substring(0, prefix.length() - 1);
            }
            if (prefix.length() == 0) {
                return "";
            }

        }

        return prefix;

    }
        
        public static void main(String[] args){
        String[] stringArray = {"car", "ca", "cali"};
        String result = longestSubstringPrefix(stringArray);
        System.out.println("Test results: " + result);
        }

}
