package misc;

/**
 * Calculate n-th root using binary search approach
 *
 * @author Konstantin Antipin
 */
public class SquareRoot {

    public static double root(double x, int power, double error) {
        double min = 0;
        double max = x;

        double tmp;
        double mid;
        do {
            mid = (max + min) / 2.0;
            tmp = Math.pow(mid, power);
            if (tmp > x)
                max = mid;
            else
                min = mid;
        } while (Math.abs(tmp - x) > error);
        return mid;
    }

    public static void main(String[] args) {
        System.out.println(root(7, 2, 0.01));
    }
}
