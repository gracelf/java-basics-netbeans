package javaBasics.comparatorExample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javaBasics.comparatorExample.Student.SortByRollNum;

/**
 *https://www.javatpoint.com/difference-between-comparable-and-comparator
 * https://www.geeksforgeeks.org/comparable-vs-comparator-in-java/
 */

public class TestCoComparator {

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
        //Collections.sort(students);
        /// this is comparable example
        System.out.println("Students List after sorting by name, ascending: " + students);

        //equality=> compare student4 and 5, returns true, because of the defined rule to compare the name to check if they are equal
        System.out.println("Student 4 and 5 are equal: " + student4.equals(student5));

        //comparator
        Student.SortByRollNum sortByRollNum = new SortByRollNum();
        Collections.sort(students, sortByRollNum);
        System.out.println("Students List after sorting by Roll Num: " + students);
        StudentNameComparator sortByName = new StudentNameComparator();
        Collections.sort(students, sortByName);
        System.out.println("Students List after sorting by name Descending: " + students);
        //static method defined in Student class
        Collections.sort(students, Student.byAge);
        System.out.println("Students List after sorting by age: " + students);
        
        //lambda function, overrides abstarct method compare(T o1, T o2)  in Comparator.java =>a  funtional interface 
        Comparator<Student> byName
                = (Student studt1, Student studt2) -> studt1.getName().compareTo(studt2.getName());
        Collections.sort(students, byName);
        System.out.println("Lambda function, Students List after sorting by name: " + students);
    }

}
