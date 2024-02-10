package benchmark;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

/**
 *
 * To make a comparison benchmark of two ways to calculate square:
 * - using i*i
 * - using Math.power(i, 2)
 *
 * The outcome is unexpectedly - diff in time performance is not significant
 * around 30%. The side effect is with multiplication using long type, the limitation
 * is rather short, square of 100 000 already get overflowed, while with Math.pow()
 * operating double we can calc quite as well 1 billion number
 *
 * Given formula:
 * p^2 / 6 = (1 / 1^2) + (1 / 2^2) + ... + (1 / n^2)
 *
 * where n - is a positive integer
 *
 * write a method that will return back p:
 * public double calculate(int n)
 *
 */

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
@Fork(value = 1, warmups = 1)
@Warmup(iterations = 3, time = 3000, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 5, time = 3000, timeUnit = TimeUnit.MILLISECONDS)
public class InverseSquareSequence {

    InverseSquareSequence instance;

    public static void main(String[] args) throws Exception {
        InverseSquareSequence inverseSquareSequence = new InverseSquareSequence();
//        System.out.println("Result: " + inverseSquareSequence.calculate1(50000));
//        System.out.println("Result: " + inverseSquareSequence.calculate2(100000000));

//        org.openjdk.jmh.Main.main(args);
    }

    @Setup
    public void setup() {
        this.instance = new InverseSquareSequence();
    }

    @Benchmark
    public void caculate1_50000() {
        instance.calculate1(50000);
    }

    @Benchmark
    public void caculate2_50000() {
        instance.calculate2(50000);
    }

    public double calculate1(int n) {
        // ensure no 0 coming
        if (n == 0) {
            return -1d;
        }

        // we can start with 1-st element in the sum already
        double sum = 1;

        // make sure index i starts from 1, not 0! - and ends with n
        for (int i = 2; i <= n; i++) {
            // don't use Math.pow() for square calculation, i*i integer operation would be much faster
            long square = i*i;
            sum += (1 / (double) square);
        }
//        System.out.println("Sum: " + sum);

        sum *= 6;
        return Math.sqrt(sum);
    }

    public double calculate2(int n) {
        double sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += 1 / Math.pow(i, 2);
        }
        sum *= 6;
        return Math.sqrt(sum);
    }
}
