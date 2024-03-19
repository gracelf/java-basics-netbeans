

package designPattern.abstractFactory;

/**
 *
 */
public class AbstractFactoryPatternDemo {
    
    public static void main(String[] args){
        //get the factory
        AbstractFactory factory = FactoryProducer.getFactory(false);
        //use factory to draw
        Shape rectangle = factory.getShape("rectangle");
        rectangle.draw();
        Shape square = factory.getShape("Square");
        square.draw();
        
        AbstractFactory roundedFactory = FactoryProducer.getFactory(true);
        Shape roundedShape = roundedFactory.getShape("Rectangle");
        roundedShape.draw();
        
    
    }

}
