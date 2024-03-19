

package designPattern.builder.builderMethod;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 */
public class BuilderMethodDemo {
    public static void main (String[] args) {
        StudentReceiverBuilder srb = new StudentReceiverBuilder();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(BuilderMethodDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(int i = 0; i<2; i++){
        System.out.println("student builder: " + srb.getStudent());}
    
    }

}
