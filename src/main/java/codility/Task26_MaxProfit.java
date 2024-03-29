package codility;


public class Task26_MaxProfit {

    public int solution(int[] A) {
        int maxProfit = 0;
        int cumulativeProfit = 0;

        for (int i = 1; i < A.length; i++) {
            int profitThisDay = A[i] - A[i - 1];
            if (profitThisDay > maxProfit) {
                maxProfit = profitThisDay;
            }
            cumulativeProfit += profitThisDay;
            if (cumulativeProfit > 0) {
                if (cumulativeProfit > maxProfit) {
                    maxProfit = cumulativeProfit;
                }
            } else {
                cumulativeProfit = 0;
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) throws Exception {
        Task26_MaxProfit maxProfit = new Task26_MaxProfit();
        System.out.println(maxProfit.solution(new int[] {23171, 21011, 21123, 21366, 21013, 21367}));
    }
}
