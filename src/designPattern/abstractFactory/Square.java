package designPattern.abstractFactory;

import designPattern.factory.*;

/**
 *
 */
public class Square implements Shape {

    @Override
    public void draw() {
        System.out.print("drawing a square");
    }

}
