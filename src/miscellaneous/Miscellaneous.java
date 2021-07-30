

package miscellaneous;

/**
 *
 * @author grace.fu
 */
public class Miscellaneous {
    
    public static void main(String[] args) throws InterruptedException {
        
        //indexOf function, returns the position of the first occurrence of specified character(s) in a string
        String test = "leetcode";
        int index = test.indexOf("code");    
        System.out.println("Index:" + index);
        
        //contain function
        String s1 = "leetcode";
        String s2 = "Leet";
        boolean contain =  s1.contains(s2);
        boolean containIgnoreCase  =  s1.toLowerCase().contains(s2.toLowerCase());
        System.out.println("contain:" + contain + "; containIgnoreCase: " + containIgnoreCase);
        
    }

}
