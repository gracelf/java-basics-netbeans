package coding.miscellaneous;

import java.util.HashMap;

/**
 *
 */
public class TwoSum {

    //https://leetcode.com/problems/two-sum/
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> tracker = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {

            ///key is the adds on, value is the index
            if (tracker.containsKey(nums[i])) {
                int left = tracker.get(nums[i]);
                return new int[]{left, i};
            } else {
                tracker.put(target - nums[i], i);
            }
        }
        return new int[2];
    }

}
