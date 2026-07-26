package repeat_practice.codility;


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

    public int solution2(int n) {
        int binaryGap = 0;
        int bgLength = 0;
        int[] binary = Integer.toBinaryString(n).chars().map(c -> c - '0').toArray();
        for (int i = 1; i < binary.length; i++) {
            switch (binary[i] - binary[i-1]) {
                case -1:
                    bgLength++;
                    break;
                case 0:
                    if (bgLength > 0) bgLength++;
                    break;
                case 1:
                    binaryGap = Math.max(binaryGap, bgLength);
                    bgLength = 0;
                    break;
            }
        }
        return binaryGap;
    }

    public static void main(String[] args) {
        Task1_BinaryGap binaryGap = new Task1_BinaryGap();
        System.out.println(binaryGap.solution2(1041));
        System.out.println(binaryGap.solution2(529));
        System.out.println(binaryGap.solution2(9));
    }
}
