package coding.slidingWindow;

import java.util.HashMap;
import java.util.HashSet;

/**
 * https://leetcode.com/problems/contains-duplicate-ii/
 *Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
 */
public class ContainsDuplicate {

    //my solutions
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            //for the map, "key" is value in the array, "index" is the key
            if (map.keySet().contains(nums[i])) {
                if (i - map.get(nums[i]) <= k) {
                    return true;
                }
            }
            //put value, index pair; value is uniqle
            map.put(nums[i], i);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 2, 3};
        int k = 1;
        System.out.println("result: " + containsNearbyDuplicate(nums, k));

        int[] nums2 = {1, 2, 3, 4, 1, 1};
        int k2 = 3;
        System.out.println("result: " + containsNearbyDuplicate(nums2, k2));

    }
    
    //sliding window solution
    public boolean containsNearbyDuplicateSlidingWindow(int[] nums, int k) {
        if (nums == null || k < 0) {
            throw new IllegalArgumentException("Input array is null");
        }
        if (nums.length <= 1 || k == 0) {
            return false;
        }

        HashSet<Integer> window = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                window.remove(nums[i - k - 1]);
            }
            if (!window.add(nums[i])) {
                return true;
            }
        }

        return false;
    }

}
