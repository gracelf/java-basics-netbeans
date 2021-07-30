

package serializationAndTransientAndStatic;

import java.io.*;

/**
 *
 *
 */
public class Example2 {
    public static void printdata(ObjectEmp object1)
    {
  
        System.out.println("name = " + object1.name);
        System.out.println("age = " + object1.age);
        System.out.println("a = " + object1.a);
        System.out.println("b = " + object1.b);
    }
  
public static void main(String[] args)
    {
        ObjectEmp object = new ObjectEmp("abcd", 1, 2, 3);
        String filename = "abcd.txt";
  
        // Serialization
        try {
  
            // Saving of object in a file
            FileOutputStream file = new FileOutputStream
                                           (filename);
            ObjectOutputStream out = new ObjectOutputStream
                                           (file);
  
            // Method for serialization of object
            out.writeObject(object);
  
            out.close();
            file.close();
  
            System.out.println("Object has been serialized\n"
                              + "Data before Deserialization.");
            printdata(object);
            
            //In case of transient variables:- A variable defined with transient keyword is not serialized during serialization process.This variable will be initialized with default value during deserialization. (e.g: for objects it is null, for int it is 0).
            //In case of static Variables:- A variable defined with static keyword is not serialized during serialization process.This variable will be loaded with current value defined in the class during deserialization.
            // ref: https://www.geeksforgeeks.org/serialization-in-java/
       
  
            //// value of int  variable changed, after deserailzation, age will still be the old value 1
            object.age = 4;
            // value of tranisent  variable changed, value won;t be saved
            object.a = 5;
            // value of static variable changed, after deserailzation, b will be 6
            object.b = 6;
            
        }
  
        catch (IOException ex) {
            System.out.println("IOException is caught");
        }
  
        object = null;
  
        // Deserialization
        try {
  
            // Reading the object from a file
            FileInputStream file = new FileInputStream
                                         (filename);
            ObjectInputStream in = new ObjectInputStream
                                         (file);
  
            // Method for deserialization of object
            object = (ObjectEmp)in.readObject();
  
            in.close();
            file.close();
            System.out.println("Object has been deserialized\n"
                                + "Data after Deserialization.");
            printdata(object);
        }
  
        catch (IOException ex) {
            System.out.println("IOException is caught");
        }
  
        catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException" +
                                " is caught");
        }
    }

}
