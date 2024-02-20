package misc;

/**
 *
 * Given an input string, reverse the order of words.
 *
 */
public class ReverseOrderOfWords {
    public static void main(String[] args) {
        ReverseOrderOfWords reverse = new ReverseOrderOfWords();
        System.out.println('"' + reverse.reverse("one two   three") + '"');
        System.out.println('"' + reverse.reverse("one") + '"');
    }

    private String reverse(String str) {
        StringBuilder result = new StringBuilder();
        String[] words = str.split("\s+");

        int num = words.length;
        if (num <= 1) {
            return str;
        }

        result.append(words[words.length - 1]);
        for (int i = words.length - 2; i >= 0; i--) {
            result.append(' ');
            result.append(words[i]);
        }
        return result.toString();
    }
}
