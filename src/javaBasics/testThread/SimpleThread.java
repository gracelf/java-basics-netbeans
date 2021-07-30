package javaBasics.testThread;

public class SimpleThread extends Thread {

    String message;

    SimpleThread(String msg) {
        this.message = msg;
    }

    @Override
    public void run() {
        System.out.println("test a simpleThread function that extends Thead");
    }
}
