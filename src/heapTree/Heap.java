/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heapTree;

public class Heap {

    private Node[] heapArray; // use array to represent a heap tree
    private int maxSize; // size of the array
    private int currentSize; // number of nodes in the array

    public Heap(int size) {
        this.maxSize = size;
        currentSize = 0;
        // actually creates the array
        heapArray = new Node[size];
    }

    public int getSize() {
        return currentSize;
    }

    public boolean isEmpty() {
        return (currentSize == 0);
    }

    public boolean insert(int key) {
        if (currentSize == maxSize) { // array is full
            return false;
        }

        Node newNode = new Node(key);
        // the next element index in the array is 'currentSize'
        heapArray[currentSize] = newNode;

        trickleUp(currentSize);
        currentSize++;

        return true;
    }

    public void trickleUp(int idx) {
        int parentIdx = (idx - 1) / 2;
        Node nodeToInsert = heapArray[idx];

        // loop as long as we haven't reached the root and key of nodeToInsert's parent is less than new node
        while (idx > 0 && heapArray[parentIdx].getKey() < nodeToInsert.getKey()) {
            heapArray[idx] = heapArray[parentIdx]; // move parent down
            idx = parentIdx;
            parentIdx = (parentIdx - 1) / 2; // move up
        }
        heapArray[idx] = nodeToInsert;
    }

    public Node remove() {
        Node root = heapArray[0];
        currentSize--;
        heapArray[0] = heapArray[currentSize];

        trickleDown(0);

        return root;
    }

    private void trickleDown(int idx) {

        int largerChildIdx;
        Node top = heapArray[idx]; // save last into top variable

        // will run as long as idx is not on the bottom row (at least 1 child)
        while (idx < currentSize / 2) {
            int leftChildIdx = 2 * idx + 1; // left child idx position
            int rightChildIdx = leftChildIdx + 1; // right child idx position

            // figure out which child is larger
            if (rightChildIdx < currentSize
                    && heapArray[leftChildIdx].getKey() < heapArray[rightChildIdx].getKey()) {
                largerChildIdx = rightChildIdx;
            } else {
                largerChildIdx = leftChildIdx;
            }

            if (top.getKey() >= heapArray[largerChildIdx].getKey()) {
                // successfully made root the largest key
                break;
            }

            heapArray[idx] = heapArray[largerChildIdx];
            idx = largerChildIdx; // go down

        }
        heapArray[idx] = top;

    }

    public void displayHeap() {
        System.out.println("Heap Array: ");
        // currentSize: size of the tree, number of the nodes = 8   in this case
        
        System.out.println("Current Size: " + currentSize);
//        for (int m = 0; m < currentSize; m++) {
//            if (heapArray[m] != null) {
//                System.out.print(heapArray[m].getKey() + " ");
//            }
//            System.out.println("at node index: " + m);

            // doesn't affect the shape of the tree, set this value at the begining of each loop
            int nBlanks = 32;
            // the number of items per row starts at 1 and gets incremented
            int itemsPerRow = 1;
            // the item index in current row
            int column = 0;
            // current item index
            int j = 0; 

            String dots = "...............................";
            System.out.println(dots + dots);
            while (currentSize > 0) {
                if (column == 0) {
                    for (int k = 0; k < nBlanks; k++) {
                        System.out.print(" ");
                    }
                }
                System.out.print(heapArray[j].getKey());
                //next item in the HEAP
                j++;
                if (j == currentSize) {
                    break;
                }

                column++;
                // end of row, itemsPerRow equals 1 on the first row, then *2 each next row
                if (column == itemsPerRow) {
                    nBlanks = nBlanks / 2; // half the blanks
                    itemsPerRow = itemsPerRow * 2;     // twice the items
                    column = 0;
                    // if end of the row, print next row
                    System.out.println();
                } else { // if not the end of row, print space of nBlanks
                    for (int k = 0; k < nBlanks * 2; k++) {
                        System.out.print(" ");
                    }
                }

            }
            System.out.println("\n" + dots + dots);
        }

//    }

}
