package codility;


public class Task11_CountDiv {

    public int solution(int A, int B, int K) {
        int start = (int) Math.ceil((double) A / K);
        start *= K;
        int result = (int) Math.ceil((double)(B - start)/K);
        return result;
    }

    public static void main(String[] args) {
        Task11_CountDiv countDiv = new Task11_CountDiv();
//        System.out.println(countDiv.solution(6, 11, 2));
        System.out.println(countDiv.solution(7, 11, 3));

    }
}
