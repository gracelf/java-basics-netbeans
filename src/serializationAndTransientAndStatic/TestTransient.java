

package serializationAndTransientAndStatic;

import java.io.*;

/**
 *
 *
 */
public class TestTransient implements Serializable
{
    // Normal variables
    int i = 10, j = 20;
  
    // Transient variables, variable will not be saved in the output stream file
    transient int k = 30;
    transient String  st = "test";
  
    // Use of transient has no impact here
    transient static int l = 40;
    transient final int m = 50;
    
  
    public static void main(String[] args) throws Exception
    {
        TestTransient input = new TestTransient();
  
        // serialization
        FileOutputStream fos = new FileOutputStream("abc.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(input);
  
        // de-serialization
        FileInputStream fis = new FileInputStream("abc.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        TestTransient output = (TestTransient)ois.readObject();
        System.out.println("i = " + output.i);
        System.out.println("j = " + output.j);
        //returns k = 0
        System.out.println("k = " + output.k);
        //returns st = null
        System.out.println("st = " + output.st);
        System.out.println("l = " + output.l);  
        System.out.println("m = " + output.m);
    }
}
