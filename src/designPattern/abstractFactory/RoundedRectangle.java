

package designPattern.abstractFactory;

import designPattern.factory.*;

/**
 *
 */
public class RoundedRectangle implements Shape{
    
    @Override
    public void draw(){
        System.out.print("drawing a rounded rectangle");
    }

}
