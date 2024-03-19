

package designPattern.factory;

/**
 *https://www.tutorialspoint.com/design_pattern/factory_pattern.htms
 */
public class FactoryPatternDemo {

   public static void main(String[] args) {
      ShapeFactory shapeFactory = new ShapeFactory();

      //get an object of Circle and call its draw method.
      ShapeInterface shape1 = shapeFactory.getShape("CIRCLE");

      //call draw method of Circle
      shape1.draw();

      //get an object of Square and call its draw method.
      ShapeInterface shape3 = shapeFactory.getShape("SQUARE");

      //call draw method of square
      shape3.draw();
   }
}
