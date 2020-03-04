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
import org.junit.After;
import org.junit.Test;

/**
 *
 * @author grace.fu
 */
public class StudentComparableTest {

    public StudentComparableTest() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of compareTo method, of class StudentComparable.
     */
    @Test
    public void testCompareTo() {
// create ArrayList to store Student 
        List<StudentComparable> al = new ArrayList<>();

        // create customer objects using constructor initialization 
        StudentComparable obj1 = new StudentComparable("Ajay", 27);
        StudentComparable obj2 = new StudentComparable("Sneha", 23);
        StudentComparable obj3 = new StudentComparable("Simran", 37);
        StudentComparable obj4 = new StudentComparable("Ajay", 22);
        StudentComparable obj5 = new StudentComparable("Ajay", 29);
        StudentComparable obj6 = new StudentComparable("Sneha", 22);

        // add customer objects to ArrayList 
        al.add(obj1);
        al.add(obj2);
        al.add(obj3);
        al.add(obj4);
        al.add(obj5);
        al.add(obj6);

        // before Sorting arraylist: iterate using Iterator 
        Iterator<StudentComparable> custIterator = al.iterator();

        System.out.println("Before Sorting:\n");
        while (custIterator.hasNext()) {
            System.out.println(custIterator.next());
        }

        // sorting using Collections.sort(al, comparator); 
//        Collections.sort(al, new CustomerSortingComparator());
        Collections.sort(al);

        // after Sorting arraylist: iterate using enhanced for-loop 
        System.out.println("\n\nAfter Sorting by default:\n");
        for (StudentComparable customer : al) {
            System.out.println(customer);
        }

        // sort by customer
        Collections.sort(al, new StudentComparable.Sortbyroll());
        // after Sorting arraylist: iterate using enhanced for-loop 
        System.out.println("\n\nAfter Sorting by roll:\n");
        for (StudentComparable customer : al) {
            System.out.println(customer);
        }

        // sort by customer
        Collections.sort(al, new CustomerSortingComparator());
        // after Sorting arraylist: iterate using enhanced for-loop 
        System.out.println("\n\nAfter Sorting by customer sorting:\n");
        for (StudentComparable customer : al) {
            System.out.println(customer);
        }
    }

    static class CustomerSortingComparator implements Comparator<StudentComparable> {

        @Override
        public int compare(StudentComparable customer1, StudentComparable customer2) {

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
}
