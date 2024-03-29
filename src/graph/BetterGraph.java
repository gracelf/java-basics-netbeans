/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

public class BetterGraph {

    Vertex[] arrayOfLists;
    int indexCounter = 0;
    boolean undirected = true;

    class Node {

        public int vertexIdx;
        //Node.next = the value passed in the second argument in the intinalizer
        public Node next;

        public Node(int vertexIdx, Node node) {
            this.vertexIdx = vertexIdx;
            // the argument node passed in => Node.next
            next = node;
        }
    }

    //like a hashmap
    class Vertex {

        String name;
        Node adjList;

        Vertex(String name, Node aNode) {
            this.name = name;
            this.adjList = aNode;
        }
    }

    public BetterGraph(int vCount, String graphType) {

        if (graphType.equals("directed")) {
            undirected = false;
        }

        arrayOfLists = new Vertex[vCount];
    }

    public void addVertex(String vertexName) {
        arrayOfLists[indexCounter] = new Vertex(vertexName, null);
        indexCounter++;
    }

    public void addEdge(String srcVertexName, String destVertexName) {
        int v1Idx = indexForName(srcVertexName);
        int v2Idx = indexForName(destVertexName);
        // scr v1Idx, destination v2Idx, add v2Idx to the end of the v1 Node => arrayOfLists[v1Idx].adjList.next = 
        arrayOfLists[v1Idx].adjList = new Node(v2Idx, arrayOfLists[v1Idx].adjList);
        int idx2 = arrayOfLists[v1Idx].adjList.vertexIdx;
        System.out.println("====add Edge for directed, idx v1: "+ v1Idx + ", v2Idx:" + idx2);
        // arrayOfLists[v1Idx].adjList.next is null, meanning next doesn't exist
        if(arrayOfLists[v1Idx].adjList.next !=null){
        int nextIdx =  arrayOfLists[v1Idx].adjList.next.vertexIdx;
        System.out.println("====next for arrayOfLists[v1Idx].adjList: " + nextIdx);
        }
        
        if(arrayOfLists[v2Idx].adjList!=null && arrayOfLists[v2Idx].adjList.next !=null){
        int nextIdx2 =  arrayOfLists[v2Idx].adjList.next.vertexIdx;
        System.out.println("====next for arrayOfLists[v2Idx].adjList: " + nextIdx2);
        }
        String adjListName = arrayOfLists[idx2].name;
        System.out.println("added Edge for directed, idx1: " + v1Idx + ", adjList: " + idx2 + ", idx2 name: " + adjListName);
        if (undirected) {
            arrayOfLists[v2Idx].adjList = new Node(v1Idx, arrayOfLists[v2Idx].adjList);
        }
    }

    int indexForName(String name) {
        for (int v = 0; v < arrayOfLists.length; v++) {
            if (arrayOfLists[v].name.equals(name)) {
                return v;
            }
        }
        return -1;
    }

    public void print() {
        System.out.println();
        for (int v = 0; v < arrayOfLists.length; v++) {
            System.out.print(arrayOfLists[v].name);
            for (Node aNode = arrayOfLists[v].adjList; aNode != null; aNode = aNode.next) {
                System.out.print(" --> " + arrayOfLists[aNode.vertexIdx].name);
            }
            System.out.println("\n");
        }
    }

}
