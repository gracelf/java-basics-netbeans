package javaBasics.testThread;

import java.util.concurrent.ExecutorService;

/**
 *
 .
 */
public class TestThread {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new SimpleThread(
                "SimpleThread executed using Thread");
        thread.start();
        thread.join();

//        executorService.submit(new SimpleThread(
//      "SimpleThread executed using ExecutorService")).get();

        // use runnable implementation
        Thread thread2 = new Thread(new SimpleRunnable());
        thread2.start();
        thread2.join();
    }

}
