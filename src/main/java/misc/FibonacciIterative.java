package misc;

import java.util.ArrayList;
import java.util.List;

public class FibonacciIterative {
    public static List<Integer> solution(int limit) {
        List<Integer> result = new ArrayList<>();
        if(limit<1) return result;
        int i1=0;
        int i2=1;
        result.add(i1);
        result.add(i2);
        int i=1;
        while(i<limit){
            result.add(i);
            i1=i2;
            i2=i;
            i=i1 + i2;
        }
        return result;
    }


    public static void main(String[] args) {
        List<Integer> result = solution(20);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}
