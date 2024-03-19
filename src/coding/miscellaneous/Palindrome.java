

package coding.miscellaneous;

import java.util.ArrayList;

/**
 *https://leetcode.com/problems/longest-palindrome/
 */
public class Palindrome {
    
     //https://leetcode.com/problems/longest-palindrome/
        public static int longestPalindrome(String s) {
        int[] count = new int[128];
        for (char c: s.toCharArray())
            count[c]++;

        int ans = 0;
        for (int v: count) {
            ans += v / 2 * 2;
            if (ans % 2 == 0 && v % 2 == 1)
                ans++;
        }
        return ans;
    }
        
        public static boolean isPalindrome(String s) {
        if (s == null) {
        }
        s.isEmpty();
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        String test = s.toLowerCase();
        char[] chars = test.toCharArray();
        int start = 0;
        int end = chars.length - 1;
        while (start < end) {
            if (chars[start] != chars[end]) {
                return false;
            }
            start++;
            end--;

        }
        return true;

    }

    public static boolean isPalindrome(int x) {
        
        // convert input into an array and rest is nothing but a simple two pointer solution
        char[] nums = String.valueOf(x).toCharArray();
        int i = nums.length;
        String str = String.valueOf(x);
        str.length();

        ArrayList<String> cars = new ArrayList<String>();

        int result[] = {0, 9};

        String[] test = {"test1", "test2"};

        int start = 0;

        int end = nums.length - 1;
        while (start < end) {
            if (nums[start] != nums[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    
    public static void main(String[] args){
        System.out.println("result: " + isPalindrome("aba"));

        String test2 = "abcdefg";
        System.out.println("substring: " + test2.substring(0, 1));

    }

}
