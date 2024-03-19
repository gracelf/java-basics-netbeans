

package coding.longestSubstring;

/**
 *
 */
public class LengthOfLongestSubstring {
    
    
    // Example 1: [3=1,20=2,10=2, 2=1, 1=1, 20=3,5], Result = 3, SubSequence = 3,10,20
public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int [] dp = new int[nums.length];
        int max = 1;
        for (int i = nums.length - 1; i >= 0; --i) {
            dp[i] = 1;
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums[j] > nums[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }


public int lengthOfLISMyPractice(int[] nums) {
        // dp[i] is the length of longest LIP ending at i
        int[] dp = new int[nums.length];      
        int answer = 0;
        
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            answer = Math.max(answer, dp[i]);
        }
        return answer;
    }
        


}
