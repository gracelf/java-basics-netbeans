package designPattern.abstractFactory;

import designPattern.factory.*;

/**
 *
 */
public class RoundedSquare implements Shape {

    @Override
    public void draw() {
        System.out.print("drawing a rounded square");
    }

}
