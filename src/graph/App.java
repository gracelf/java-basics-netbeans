/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

public class App {

    public static void main(String[] args) {

        BetterGraph myGraph = new BetterGraph(5, "directed");
        myGraph.addVertex("State");
        myGraph.addVertex("Avenel");
        myGraph.addVertex("Elm");
        myGraph.addVertex("Pocono");
        myGraph.addVertex("William");

//        myGraph.addEdge("Avenel", "Pocono");
//        myGraph.addEdge("State", "Elm");
        myGraph.addEdge("Elm", "Avenel");
        myGraph.addEdge("Elm", "William");
//        myGraph.addEdge("William", "State");
//        myGraph.addEdge("William", "Pocono");
//        myGraph.addEdge("Pocono", "Elm");
//        myGraph.addEdge("State", "Avenel");

        myGraph.print();

//		Object [] values = myGraph.adj(1);
//		for(Object val : values){
//			System.out.println(val);
//		}
    }

}
