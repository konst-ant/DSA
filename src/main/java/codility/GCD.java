package codility;

public class GCD {

    public static int gcd(int first, int second) {

        int a = first;
        int b = second;
        int r, i;
        while(b!=0){
            r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(GCD.gcd(12, 18));
    }
}
