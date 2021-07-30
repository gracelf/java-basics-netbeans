package javaBasics.comparatorExample;

import java.util.Comparator;

/**
 *
 */
public class StudentNameComparator implements Comparator<Student> {
    // Used for sorting in Descending order of  student name
    @Override
    public int compare(Student a, Student b) {
        //Descending order
        return b.getName().compareTo(a.getName());
    }

}
