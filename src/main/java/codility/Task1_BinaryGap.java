package codility;


public class Task1_BinaryGap {

    public int solution(int n) {
        String binary = Integer.toBinaryString(n);
        boolean started = false;
        int counter = 0;
        int maxCounter = 0;
        for (Character c : binary.toCharArray()) {
            if (c == '1') {
                if (started) {
                    maxCounter = Math.max(maxCounter, counter);
                }
                counter = 0;
                started = true;
            } else {
                counter++;
            }
        }
        return maxCounter;
    }

    public static void main(String[] args) {
        Task1_BinaryGap binaryGap = new Task1_BinaryGap();
        System.out.println(binaryGap.solution(1041));
        System.out.println(binaryGap.solution(529));
        System.out.println(binaryGap.solution(9));
    }
}
