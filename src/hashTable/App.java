/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashTable;

public class App {
    public static void main(String[] args) {
        HashTable h = new HashTable(15);
        h.insert("Apple");
        h.insert("Hello");
        h.insert("Feeling");
        h.insert("Water");
        h.insert("Africa");
        h.insert("Speed");
        h.insert("Phone");
        h.insert("September");
        h.insert("Michael");
        h.insert("Milk");
        h.insert("Huge");
        h.insert("Dogs");
 
        System.out.println("--- Find Elements ---");
        System.out.println("Apple   : " + h.find("Apple"));
        System.out.println("Zebra   : " + h.find("Zebra")); // No such
        System.out.println("Feeling : " + h.find("Feeling"));
        System.out.println("Water   : " + h.find("Water"));
        System.out.println("Africa  : " + h.find("Africa"));
        System.out.println("----");
        h.displayHashTable();
    }
}
