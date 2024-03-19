

package coding.longestSubstring;

import coding.miscellaneous.TestingBasics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 *
 */
public class DP_FindLengthOfLongestIncreasingSubSequence {
      /**
* 
* Find the longest strictly increasing subsequence of a given sequence /      array.
*
* In other words, find the length of a subsequence of array in which the elements of the sub-sequence are in strictly increasing order,
* and in which the sub-sequence is as long as possible.
* This sub-sequence is not necessarily contiguous, or unique.
* In this case, we only care about the length of the longest increasing  subsequence.
* Example 1: [3=1,20=2,10=2, 2=1, 1=1, 20=3,5], Result = 3, SubSequence = 3,10,20
* Example 2: [5,0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15], Result = 6 Possible-Sub-Sequence 0,4,6,9,11,15
**/


    public static int findLengthOfLongestIncreasingSubSequence(int[] array) {

        ArrayList<Integer> storedVal = new ArrayList<>();
        
        storedVal.add(1);

        for (int i = 1; i < array.length; i++) {

            int max = 0;

            //int index = i;

            for (int j = i-1; j >= 0; j--) {
                if (array[j] < array[i]) {
                    if (max < storedVal.get(j))
                    {
                    max = storedVal.get(j);
                    System.out.println("j = " + j + ", max=" + max + ", storedVal.get(j): " + storedVal.get(j));
                    }
                }

            }

            max = max + 1;
            
            System.out.println("loop i = " + i + ", max=" + max);
            storedVal.add(max);

        }
        
        System.out.print("stored val list: " + storedVal);

        return Collections.max(storedVal);

    }
    
    public static void main(String args[]) {

       
        HashMap<String, Integer> tracker = new HashMap<String, Integer>();
        tracker.put("Key1", 6);
        tracker.put("Key2", 6);
        tracker.put("Key1", 7);
        ///get value by key
        Integer value = tracker.get("Key1");
        boolean contains = tracker.containsKey("key3");
        boolean containsValue = tracker.containsValue(7);

        System.out.println("value: " + value + ", contains key: " + contains + containsValue);

        int[] test = {5, 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        int result2 = findLengthOfLongestIncreasingSubSequence(test);
        System.out.println("findLengthOfLongestIncreasingSubSequence, result: " + result2);

    }
    

}
