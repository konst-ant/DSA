package codility;


public class Task21_Nesting {

    public int solution(String S) {
        int counter=0;
        for (Character c : S.toCharArray()) {
            if (c == '(') {
                counter++;
            } else if (c == ')') {
                if (counter == 0) {
                    return 0;
                }
                counter--;
            }
        }
        return counter == 0 ? 1 : 0;
    }

    public static void main(String[] args) throws Exception {
        Task21_Nesting nesting = new Task21_Nesting();
        System.out.println(nesting.solution("())"));
//        System.out.println(nesting.solution("(()(())())"));
    }
}
