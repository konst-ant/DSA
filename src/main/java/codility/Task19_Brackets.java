package codility;


import java.util.HashMap;
import java.util.Stack;

public class Task19_Brackets {

    public int solution(String S) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> pairs = new HashMap<>();

        pairs.put('{', '}');
        pairs.put('[', ']');
        pairs.put('(', ')');

        for (Character c : S.toCharArray()) {
            if (pairs.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return 0;
                }
                if (!c.equals(pairs.get(stack.peek()))) {
                    return 0;
                }
                stack.pop();
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }

    public static void main(String[] args) throws Exception {
        Task19_Brackets triangle = new Task19_Brackets();
//        System.out.println(triangle.solution("{[()()]}"));
//        System.out.println(triangle.solution("([)()]"));
        System.out.println(triangle.solution(")[)()]"));
    }
}
