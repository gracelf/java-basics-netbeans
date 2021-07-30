/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortAlgorithm;

import java.util.Arrays;

public class MergeSort {

    public static void sort(int inputArray[]) {
        sort(inputArray, 0, inputArray.length - 1);
    }

    public static void sort(int inputArray[], int start, int end) {
        System.out.println("start sort function, start:" + start + ", end:" + end);
        if (end <= start) {
            System.out.println("--------------end spliting, return nothing, do nothing");
            return; // done traversing the array
        }

        int mid = (start + end) / 2;
        System.out.println("about to split, mid:" + mid);
        System.out.println("!!left, start:" + start + ", mid:" + mid);
        sort(inputArray, start, mid); // sort left half
        System.out.println("done left");
        System.out.println("!!right, mid+1:" + (mid + 1) + ", end:" + end);
        sort(inputArray, mid + 1, end); // sort right half
        System.out.println("done right");

        merge(inputArray, start, mid, end); // merge sorted results into the inputArray
    }

    public static void merge(int inputArray[], int start, int mid, int end) {

        System.out.println("=================== start merge, start:" + start + ", end:" + end);
        int tempArray[] = new int[end - start + 1];

        // index counter for the left side of the array
        int leftSlot = start;
        // index counter for the right side of the array
        int rightSlot = mid + 1;
        int k = 0;

        while (leftSlot <= mid && rightSlot <= end) {
            if (inputArray[leftSlot] < inputArray[rightSlot]) {
                tempArray[k] = inputArray[leftSlot];
                leftSlot = leftSlot + 1;
            } else {
                tempArray[k] = inputArray[rightSlot];
                rightSlot = rightSlot + 1;
            }
            k = k + 1;
        }

        /**
         * now both the right and the left side of the sub-array can be considered sorted
         */
        if (leftSlot <= mid) { // consider the right side done being sorted. Left must be sorted already
            while (leftSlot <= mid) {
                tempArray[k] = inputArray[leftSlot];
                leftSlot = leftSlot + 1;
                k = k + 1;
            }
        } else if (rightSlot <= end) {
            while (rightSlot <= end) {
                tempArray[k] = inputArray[rightSlot];
                rightSlot = rightSlot + 1;
                k = k + 1;
            }
        }

        // copy over the tmep array into the appropriate slots of the inputArray
        for (int i = 0; i < tempArray.length; i++) {
            inputArray[start + i] = tempArray[i];
        }

        System.out.println("====putArray after the merge" + Arrays.toString(inputArray));
        System.out.println("==========================================");

    }

    /*in-place merge. 
     * @param inputArray
     * @param start
     * @param mid
     * @param end
     */
    private static int tempArray[]; // an array used for merging
    // To use the mergeInPlace() method, you'll need to initialize tempArray as 
    // shown on the next line inside of the wrapper sort() method.
    // tempArray = new int [inputArray.length]; 

    public static void mergeInPlace(int inputArray[], int start, int mid, int end) {
        int i = start; // save starting index into temporary variable
        int j = mid + 1;

        for (int k = 0; k <= end; k++) {
            tempArray[k] = inputArray[k];
        }

        for (int k = start; k <= end; k++) {
            if (i > mid) {
                inputArray[k] = tempArray[j];
                j = j + 1;
            } else if (j > end) {
                inputArray[k] = tempArray[i];
                i = i + 1;
            } else if (tempArray[j] < tempArray[i]) {
                inputArray[k] = tempArray[j];
                j = j + 1;
            } else {
                inputArray[k] = tempArray[i];
                i = i + 1;
            }
        }
    }

}
