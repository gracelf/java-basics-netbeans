/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortAlgorithm;

/**
 *
 *
 */
public class App {

    public static void main(String[] args) {

        int[] inputArray = {8, 7, 6, 5, 4, 3, 2, 1};
        MergeSort sorter = new MergeSort();

        sorter.sort(inputArray);

        for (int i = 0; i < inputArray.length; i++) {
            System.out.println(inputArray[i]);
        }

    }

}
