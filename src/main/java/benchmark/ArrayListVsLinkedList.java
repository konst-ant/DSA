package benchmark;

import org.openjdk.jmh.annotations.*;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * This benchmark based on Java Microbenchmark Harness (jmh) library is to demonstrate
 * ArrayList <=> LinkedList so oftenly argued and discussed topic of what to use when.
 *
 * See ArrayListVsLinkedList_Benchmark.png for self-speaking results
 */


@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
@Fork(value = 1, warmups = 1)
@Warmup(iterations = 3, time = 3000, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 5, time = 3000, timeUnit = TimeUnit.MILLISECONDS)
public class ArrayListVsLinkedList {

    private String[] dataArray = null;

    @Param({"10000"})
    int SIZE;
    int mid;
    int end;

    List<String> arrayList;
    List<String> linkedList;

    @Setup
    public void load() {
        mid = SIZE / 2;
        end = SIZE - 1;

        // Load Array
        dataArray = new String[SIZE];
        for (int x = 0; x < SIZE; ++x) {
            dataArray[x] = "";
        }

        arrayList = new ArrayList<>(Arrays.asList(dataArray));
        linkedList = new LinkedList<>(Arrays.asList(dataArray));
    }

    // ArrayList

    @Benchmark
    public String AL_accessFirst() {
        return arrayList.get(0);
    }

    @Benchmark
    public String AL_accessMiddle() {
        return arrayList.get(mid);
    }

    @Benchmark
    public String AL_accessLast() {
        return arrayList.get(end);
    }

    @Benchmark
    public String AL_editFirst() {
        arrayList.add(0, "Dawson College");
        return arrayList.remove(0);
    }

    @Benchmark
    public String AL_editMiddle() {
        arrayList.add(mid, "Dawson College");
        return arrayList.remove(mid);
    }

    @Benchmark
    public String AL_editLast() {
        arrayList.add(end, "Dawson College");
        return arrayList.remove(end);
    }

    // LinkedList

    @Benchmark
    public String LL_accessFirst() {
        return linkedList.get(0);
    }

    @Benchmark
    public String LL_accessMiddle() {
        return linkedList.get(mid);
    }

    @Benchmark
    public String LL_accessLast() {
        return linkedList.get(end);
    }

    @Benchmark
    public String LL_editFirst() {
        linkedList.add(0, "Dawson College");
        return linkedList.remove(0);
    }

    @Benchmark
    public String LL_editMiddleIndx() {
//        linkedList.add(mid, "Dawson College");
        return linkedList.remove(mid);
    }

    @Benchmark
    public String LL_editMiddleIter() {
        ListIterator<String> iter = linkedList.listIterator(mid);
//        iter.add("Dawson College");
//        String r = iter.previous();
        String r = iter.previous();
        iter.remove();
        return r;
    }

    @Benchmark
    public String LL_editLast() {
        linkedList.add(end, "Dawson College");
        return linkedList.remove(end);
    }

    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }
}
