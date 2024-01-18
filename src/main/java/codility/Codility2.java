package codility;

public class Codility2 {

    public int solution(int[] A) {

        int list_length = 1;
        int pointer = A[0];
        while (pointer != -1) {
            list_length++;
            pointer = A[pointer];
        }

        return list_length;
    }

    public static void main(String[] args) {
        Codility2 codility = new Codility2();
        System.out.println(codility.solution(new int[] {
                1,
                4,
                -1,
                3,
                2
        }));
    }
}
