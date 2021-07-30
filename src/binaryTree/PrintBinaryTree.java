/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 *
 * question https://leetcode.com/problems/print-binary-tree/
 * ref: https://leetcode.com/problems/print-binary-tree/discuss/106239/Java-Recursive-Solutions, https://www.youtube.com/watch?v=ipIL1qVAazk
 */
public class PrintBinaryTree {
    
    public List<List<String>> printTree(TreeNode root) {
        int currentHeight = 0;
    List<List<String>> ans = new LinkedList<>();
    int height = root == null ? 1 : getHeight(root, currentHeight);
    int rows = height; 
    int columns = (int) (Math.pow(2, height) - 1);
    System.out.println("columns: " + columns);
    // make a rectangular base answer
    List<String> row = new ArrayList<>();
    for(int i = 0; i < columns; i++)  row.add("");
    System.out.println("row with space: " + row.toString());
    //deep copy, example https://howtodoinjava.com/java/collections/arraylist/arraylist-clone-deep-copy/
    for(int i = 0; i < rows; i++)  ans.add(new ArrayList(row));
    populateAns(root, ans, 0, 0, columns - 1);
    return ans;
}

public void populateAns(TreeNode root, List<List<String>> ans, int row, int i, int j) {
    if (root == null) return;
    int mid = (i+j)/2;
    ans.get(row).set(mid, Integer.toString(root.value));
    populateAns(root.left, ans, row+1, i, mid - 1);
    populateAns(root.right, ans, row+1, mid+1, j);
}

public int getHeight(TreeNode root, int currentHeight) {
     if (root == null) return 0;
          currentHeight ++;
     System.out.println(root.value + "current height:" + currentHeight);

     return 1 + Math.max(getHeight(root.left, currentHeight), getHeight(root.right, currentHeight));
}
    
}
