

package designPattern.prototype;

/**
 *
 */
public class Rectangle extends Shape {
    
    Rectangle(){
        // parent class, property => type, define in constructor, not setter method
        type = "Rectangle";
    
    }
    
    @Override
    void draw() {
     System.out.println("drawing a rectangle");
    }

}
