package interview.ooma;


import java.util.Objects;
import java.util.TreeSet;
import java.util.concurrent.*;

/**
 * Test task given on interview with Ooma company
 *
 * Q: what will be printed out
 *
 * A: Basically should be set of { (0,0) (0,1), (1,0), (1,1) } but prints { (0,0) (1,1) }
 */
public class OomaConcurrency {

    private static ExecutorService executorService = Executors.newFixedThreadPool(2);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        OomaConcurrency oomaConcurrency = new OomaConcurrency();

        oomaConcurrency.testRuns();

        executorService.shutdownNow();
    }

    public void testRuns() throws ExecutionException, InterruptedException {
        int count = 100;
        TreeSet<Result> out = new TreeSet<>();

        for (int i=0; i<count; i++) {
            Result result = singleTestRun();
            out.add(result);
        }

        for (Result r : out) {
            System.out.println(String.format("%s", r));
        }
    }

    public Result singleTestRun() throws  ExecutionException, InterruptedException {
        State state = new State();
        Result result = new Result();

        Future f2 = executorService.submit(() -> {
            try {
                new ThreadTest().act2(state, result);
            } catch (InterruptedException e) {
                Thread.interrupted();
            }
        });

        Future f1 = executorService.submit(() -> {
            try {
                new ThreadTest().act1(state);
            } catch (InterruptedException e) {
                Thread.interrupted();
            }
        });

        f1.get();
        f2.get();

        return result;
    }


    static class Result implements Comparable {

        int r1;
        int r2;

        @Override
        public int compareTo(Object o) {
            return toString().compareTo(o.toString());
        }

        @Override
        public String toString() {
            return r1 + "," + r2;
        }

        @Override
        public boolean equals(Object o) {
            if (o == this) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Result result = (Result) o;
            return r1 == result.r1 && r2 == result.r2;

        }

        @Override
        public int hashCode() {
            return Objects.hash(r1, r2);
        }
    }

    static class State {
        volatile int x;
        volatile int y;
    }

    static class ThreadTest {
        public void act1(State state) throws InterruptedException{
            Thread.sleep(Math.abs(ThreadLocalRandom.current().nextLong(10l)));
            state.y =1;
            state.x = 1;
        }

        public void act2(State state, Result result) throws InterruptedException{
            Thread.sleep(Math.abs(ThreadLocalRandom.current().nextLong(10l)));
            result.r1 = state.x;
            result.r2 = state.y;
        }
    }
}
