package coding.miscellaneous;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/discuss/12072/Java-clean-code
 * https://leetcode.com/problems/find-the-duplicate-number/
 */
public class FindDuplicateFromArray {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0; // last processed item
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }

    //binary search method
    public int findDuplicate(int[] nums) {

        int low = 1, high = nums.length - 1;
        int duplicate = -1;

        while (low <= high) {
            int cur = (low + high) / 2;

            // Count how many numbers in 'nums' are less than or equal to 'cur'
            int count = 0;
            for (int num : nums) {
                if (num <= cur) {
                    count++;
                }
            }

            if (count > cur) {
                duplicate = cur;
                high = cur - 1;
            } else {
                low = cur + 1;
            }
        }
        return duplicate;

    }

    public int findDuplicateInSortedArray(int[] nums) {
        Arrays.sort(nums);

        int low = 1, high = nums.length - 1;
        int duplicate = -1;

        while (low <= high) {
            int cur = (low + high) / 2;
            System.out.println("cur: " + cur);  
            if (nums[cur] == cur){
            return cur;
            } else if (nums[cur] < cur){
            
            }
            
            
            // Count how many numbers in 'nums' are less than or equal to 'cur'
            int count = 0;
            for (int num : nums) {
                if (num <= cur) {
                    count++;
                }
            }

            if (count > cur) {
                duplicate = cur;
                high = cur - 1;
            } else {
                low = cur + 1;
            }
        }
        return duplicate;

    }
    
    
    public static void main(String[] args){
        FindDuplicateFromArray solution = new FindDuplicateFromArray();
        int[] arr = {1, 2, 2, 3, 4};
        solution.findDuplicateInSortedArray(arr);
        
    
    }

}
