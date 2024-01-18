package passedInterviews;

/**
 * Codility
 */
class TwoWoodenSticks {
    public int solution(int A, int B) {
        // Implement your solution here
        int total=A+B;
        int maxLengthTogether=total/4;
        while(maxLengthTogether >0){
            int maxLengthA=A/maxLengthTogether;
            int maxLengthB=B/maxLengthTogether;
            if(maxLengthA+maxLengthB>=4){
                return maxLengthTogether;
            }
            maxLengthTogether--;
        }
        return 0;
    }

    public static void main(String[] args) {
        TwoWoodenSticks twoWoodenSticks = new TwoWoodenSticks();
        System.out.println(twoWoodenSticks.solution(10, 21));
        System.out.println(twoWoodenSticks.solution(13, 11));
        System.out.println(twoWoodenSticks.solution(2, 1));
        System.out.println(twoWoodenSticks.solution(1, 8));
    }
}
