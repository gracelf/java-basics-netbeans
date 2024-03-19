package javaBasics.comparableExample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javaBasics.comparatorExample.Student.SortByRollNum;
import javaBasics.comparatorExample.StudentNameComparator;

/**
 *https://www.javatpoint.com/difference-between-comparable-and-comparator
 * https://www.geeksforgeeks.org/comparable-vs-comparator-in-java/
 */

public class TestComparable {

    public static void main(String[] args) {
        Student student1 = new Student(1, "Austin", 15);
        Student student2 = new Student(2, "Barbara", 17);
        Student student3 = new Student(3, "Carrie", 28);
        Student student4 = new Student(4, "Dave", 18);
        Student student5 = new Student(5, "Dave", 19);

        ArrayList<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student3);
        students.add(student2);
        students.add(student4);
        students.add(student5);
        Collections.sort(students);
        /// this is comparable example
        System.out.println("Students List after sorting by name, ascending: " + students);

        //equality=> compare student4 and 5, returns true, because of the defined rule to compare the name to check if they are equal
        System.out.println("Student 4 and 5 are equal: " + student4.equals(student5));
    }

}
