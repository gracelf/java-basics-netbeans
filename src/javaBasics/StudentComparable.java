package javaBasics;

import java.util.Comparator;

public class StudentComparable implements Comparable<StudentComparable> {

    private int rollno;
    private String name;
    private String address;
    private int age;

    // Constructor 
    public StudentComparable(String name, int rollno) {
        this.rollno = rollno;
        this.name = name;
    }

    // Used to print student details in main() 
    @Override
    public String toString() {
        return this.getRollno() + " " + this.getName()
                + " " + this.getAddress();
    }

    @Override
    public int compareTo(StudentComparable o) {
        System.out.println("this.name.compareTo(o.getName())==> " + (this.name.compareTo(o.getName())));
        System.out.println("this.name==> " + this.name + o.getName());
        return this.name.compareTo(o.getName());
    }

    public static class Sortbyroll implements Comparator<StudentComparable> {
        // Used for sorting in ascending order of 
        // roll number 

        @Override
        public int compare(StudentComparable a, StudentComparable b) {
            System.out.println("a.getRollno() - b.getRollno()==> " + (a.getRollno() - b.getRollno()));
            System.out.println("a and b" + a.getRollno() + "-" + b.getRollno());
            return a.getRollno() - b.getRollno();
        }
    }

    public static class Sortbyname implements Comparator<StudentComparable> {
        // Used for sorting in ascending order of 
        // roll name 

        @Override
        public int compare(StudentComparable a, StudentComparable b) {
            return a.getName().compareTo(b.getName());
        }
    }

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
