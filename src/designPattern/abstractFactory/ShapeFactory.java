

package designPattern.abstractFactory;

import designPattern.factory.*;

/**
 *
 */
public class ShapeFactory extends AbstractFactory{
	
   //use getShape method to get object of type shape 
   public Shape getShape(String shapeType){
      if(shapeType == null){
         return null;
      }		
      if(shapeType.equalsIgnoreCase("Rectangle")){
         return new Rectangle();       
      } else if(shapeType.equalsIgnoreCase("SQUARE")){
         return new Square();
      }
      
      return null;
   }
}
