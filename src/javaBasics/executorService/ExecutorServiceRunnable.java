package javaBasics.executorService;

/**
 * ref: https://howtodoinjava.com/java/multi-threading/executor-service-example/
 *
 */
import java.time.LocalDateTime;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExecutorServiceRunnable {

    public static void main(String[] args) {
        //Demo task
        Runnable runnableTask = () -> {
            try {
                TimeUnit.MILLISECONDS.sleep(5000);
                System.out.println("Current time :: " + LocalDateTime.now());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable runnableTask2 = () -> {
            try {
                TimeUnit.MILLISECONDS.sleep(10000);
                System.out.println("Current time task 2 :: " + LocalDateTime.now());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        //Executor service instance
        ExecutorService executor = Executors.newFixedThreadPool(10);

        //1. execute task using execute() method
        System.out.println("invoking execute() method at time: " +  LocalDateTime.now());
        executor.execute(runnableTask);

        //2. execute task using submit() method
        Future<String> result = executor.submit(runnableTask2, "DONE");
        System.out.println("invoking submit() method at time: " +  LocalDateTime.now());
        System.out.println("is done: " + result.isDone());

        while (result.isDone() == false) {
            try {
                System.out.println("result is true: " + result.isDone());
                //only print after the result is returned, weird
                System.out.println("The method return value : " + result.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        try {
            System.out.println("after result is true: " + result.isDone() + ", result: " + result.get());
        } catch (Exception ex) {
            Logger.getLogger(ExecutorServiceRunnable.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Shut down the executor service after the execution
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.shutdownNow();
    }
}
