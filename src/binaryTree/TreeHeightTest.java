/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binaryTree;

import java.util.List;

/**
 *
 */
public class TreeHeightTest {
    
    public static void main(String[] args) {
        System.out.println("test binary search tree");
        BinaryTree bt = new BinaryTree();
        bt.add(7);
        bt.add(2);
        bt.add(1);
        bt.add(8);
        bt.add(5);
        bt.add(6);
        
        PrintBinaryTree pBT = new PrintBinaryTree();
        int height = pBT.getHeight(bt.root, 0);
        System.out.println("binary search tree height: " + height);
       List<List<String>> btString = pBT.printTree(bt.root);
        System.out.println("binary search tree: " + btString.toString());
    }
    
}
