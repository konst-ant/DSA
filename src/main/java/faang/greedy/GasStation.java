package faang.greedy;

/**
 * LC 134: Gas Station.
 * Find the starting gas station index from which a car can complete the circuit, or -1 if impossible.
 * Precondition: gas and cost must be non-null, non-empty, and of equal length.
 */
public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null) {
            throw new IllegalArgumentException("gas and cost must be non-null");
        }
        if (gas.length == 0 || gas.length != cost.length) {
            throw new IllegalArgumentException("gas and cost must be non-empty and of equal length");
        }
        int totalSurplus = 0;
        int currentSurplus = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            totalSurplus += diff;
            currentSurplus += diff;
            if (currentSurplus < 0) {
                start = i + 1;
                currentSurplus = 0;
            }
        }
        return totalSurplus >= 0 ? start : -1;
    }

    public static void main(String[] args) {
        GasStation solution = new GasStation();
        System.out.println(solution.canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
        System.out.println(solution.canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3}));
        System.out.println(solution.canCompleteCircuit(new int[]{5, 1, 2, 3, 4}, new int[]{4, 4, 1, 5, 1}));
    }
}
