package javaBasics.comparatorExample;

import java.util.Comparator;

public class Student implements Comparable<Student> {

    private int rollno;
    private String name;
    private String address;
    private int age;

    // Constructor 1
    Student(int rollno, String name, int age) {
        this.rollno = rollno;
        this.name = name;
        this.age = age;
    }

    // Constructor 2
//    Student(String name, int rollno) {
//        this.rollno = rollno;
//        this.name = name;
//    }
    // Used to print student details in main() 
    @Override
    public String toString() {
        return this.getRollno() + " " + this.getName()
                + " " + this.getAge();
    }

    @Override
    public int compareTo(Student o) {
        System.out.println("this.name.compareTo(o.getName())==> " + (this.name.compareTo(o.getName())));
        System.out.println("this.name==> " + this.name + ", compare to name: " + o.getName());
        return this.name.compareTo(o.getName());
    }

    @Override
    public boolean equals(Object student) {
        if (student instanceof Student) {
            //compare the object by comparing the name, as defined in the compardTo method
            return compareTo((Student) student) == 0;
        } else {
            return false;
        }
    }

    // We don't use this object in a hash table, but we have to override hashCode function if we override equals function, and also this will satisfy Coverity scan
    @Override
    public int hashCode() {
        assert false : "hashCode not designed";
        return 42;
    }

    //Use of comparator interface, external to element class, not comparable interface as in the above example
    public static class SortByRollNum implements Comparator<Student> {

        // Used for sorting in ascending order of 
        // roll number 
        @Override
        public int compare(Student a, Student b) {
            System.out.println("a.getRollno() - b.getRollno()==> " + (a.getRollno() - b.getRollno()));
            System.out.println("a roll number: " + a.getRollno() + ", b roll number: " + b.getRollno());
            return a.getRollno() - b.getRollno();
        }
        
        // no need to override abstarct equals(Object a) method of comparator interface?
        //https://mkyong.com/java8/is-comparator-a-function-interface-but-it-has-two-abstract-methods/
        //https://stackoverflow.com/questions/43616649/how-can-comparator-be-a-functional-interface-when-it-has-two-abstract-methods/43616695
    }

    // sort by name, descending order. this static class or a new separtor class StudentNameComparator
    public static class SortByName implements Comparator<Student> {

        // Used for sorting in Descending order of 
        // student name
        @Override
        public int compare(Student a, Student b) {
            //Descending order
            return b.getName().compareTo(a.getName());
        }
    }

    //use a lambda expression to create a Comparator, use static so it can be called in test class later
    static Comparator<Student> byName = 
            (Student student1, Student student2) -> student1.getName().compareTo(student2.getName());
    
    static Comparator<Student> byAge = Comparator.comparing(Student::getAge);

    /**
     * @return the rollno
     */
    public int getRollno() {
        return rollno;
    }

    /**
     * @param rollno the rollno to set
     */
    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }
}
