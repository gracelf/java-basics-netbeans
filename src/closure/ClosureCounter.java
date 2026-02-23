package closure;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

/**
 *
 */
public class ClosureCounter {

    public static Supplier<Integer> makeCounter() {
        AtomicInteger count = new AtomicInteger(0);
        return () -> count.incrementAndGet();
    }

    public static void main(String[] args) {
        Supplier<Integer> add = makeCounter();
        System.out.println(add.get()); // 1
        System.out.println(add.get()); // 2
        System.out.println(add.get()); // 3
    }

}
