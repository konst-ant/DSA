package dp;

public class Fibonacci {

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println("Fibonacci: " + fibonacci.fibonacciRecursive(6));
        System.out.println("Fibonacci: " + fibonacci.fibonacciTabular(6));
    }

    public int fibonacciRecursive(int n) {
        int memoize[] = new int[n+1];
        int result = recursive(memoize, n);
        System.out.println("Fibonacci memoize content: ");
        for (int i : memoize) {
            System.out.println(i);
        }
        return result;
    }

    private int recursive(int[] memoize, int n) {
        if(n < 2)
            return n;

        // if we have already solved this subproblem, simply return the result from the cache
        if(memoize[n] != 0)
            return memoize[n];

        memoize[n] = recursive(memoize, n-1) + recursive(memoize, n-2);
        return memoize[n];
    }

    public int fibonacciTabular(int n) {
        if (n==0) return 0;
        int dp[] = new int[n+1];

        //base cases
        dp[0] = 0;
        dp[1] = 1;

        for(int i=2; i<=n; i++)
            dp[i] = dp[i-1] + dp[i-2];

        return dp[n];
    }
}
