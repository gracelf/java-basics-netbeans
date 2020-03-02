/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaBasics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import testComparator.Student;

/**
 *
 * @author grace.fu
 */
public class JavaBasicConceptTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

//		JavaBasicConceptTest crunchifyTest = new JavaBasicConceptTest();
//		TestHashCodeEqual one = new TestHashCodeEqual(1);
//		TestHashCodeEqual two = new TestHashCodeEqual(1);
//		crunchifyTest.test1(one, two);
// 
//		TestHashCodeEqual three = new TestHashCodeEqual(1);
//		TestHashCodeEqual four = new TestHashCodeEqual(2);
//		crunchifyTest.test2(three, four);
        // create ArrayList to store Student 
        List<Student> al = new ArrayList<>();

        // create customer objects using constructor initialization 
        Student obj1 = new Student("Ajay", 27);
        Student obj2 = new Student("Sneha", 23);
        Student obj3 = new Student("Simran", 37);
        Student obj4 = new Student("Ajay", 22);
        Student obj5 = new Student("Ajay", 29);
        Student obj6 = new Student("Sneha", 22);

        // add customer objects to ArrayList 
        al.add(obj1);
        al.add(obj2);
        al.add(obj3);
        al.add(obj4);
        al.add(obj5);
        al.add(obj6);

        // before Sorting arraylist: iterate using Iterator 
        Iterator<Student> custIterator = al.iterator();

        System.out.println("Before Sorting:\n");
        while (custIterator.hasNext()) {
            System.out.println(custIterator.next());
        }

        // sorting using Collections.sort(al, comparator); 
//        Collections.sort(al, new CustomerSortingComparator());
        Collections.sort(al);

        // after Sorting arraylist: iterate using enhanced for-loop 
        System.out.println("\n\nAfter Sorting by default:\n");
        for (Student customer : al) {
            System.out.println(customer);
        }

        // sort by customer
        Collections.sort(al, new Student.Sortbyroll());
        // after Sorting arraylist: iterate using enhanced for-loop 
        System.out.println("\n\nAfter Sorting by roll:\n");
        for (Student customer : al) {
            System.out.println(customer);
        }

        // sort by customer
        Collections.sort(al, new CustomerSortingComparator());
        // after Sorting arraylist: iterate using enhanced for-loop 
        System.out.println("\n\nAfter Sorting by customer sorting:\n");
        for (Student customer : al) {
            System.out.println(customer);
        }
    }

    static class CustomerSortingComparator implements Comparator<Student> {

        @Override
        public int compare(Student customer1, Student customer2) {

            // for comparison 
            int nameCompare = customer1.getName().compareTo(customer2.getName());
            int rollCompare = customer1.getRollno() - customer2.getRollno();

            // 2-level comparison using if-else block 
            if (nameCompare == 0) {
                return ((rollCompare == 0) ? nameCompare : rollCompare);
            } else {
                return nameCompare;
            }
        }
    }

    public void test1(TestHashCodeEqual one, TestHashCodeEqual two) {
        if (one.equals(two)) {
            System.out.println("Test1: One and Two are equal");
        } else {
            System.out.println("Test1: One and Two are not equal");
        }
    }

    public void test2(TestHashCodeEqual three, TestHashCodeEqual four) {
        if (three.equals(four)) {
            System.out.println("Test2: Three and Four are equal");
        } else {
            System.out.println("Test2: Three and Four are not equal");
        }
    }

}
