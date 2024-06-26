

package javaBasics.comparableExample;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 */
public class LambdaComparable {
    public static void main(String[] args) {
        int[] nums = new int[] {0,3,6,8,9};
        int res = getPivotIndex(nums,0,4);
        System.out.println(res);
        
    }
    private static Integer getPivotIndex(int[] nums, int start, int end){
        int rand = new Random().nextInt(end-start)+start+1;
        System.out.println("random num:" + rand);
        List<Integer> lis = Arrays.asList(start, end, rand);
        Collections.sort(lis, (idx1, idx2)-> nums[idx1]-nums[idx2]); //asceding order
        System.out.println("list:" + lis);
        return lis.get(2);//this return the  idx which has the largest nums[idx]
    }

}
