package codility;


public class Task4_FrogJump {

    public int solution(int x, int y, int D) {
        int distance = y -x;
        int jumps = (int) Math.ceil(distance / (double) D);
        return jumps;
    }

    public static void main(String[] args) {
        Task4_FrogJump froJump = new Task4_FrogJump();
        System.out.println(froJump.solution(10, 85, 30));

    }
}
