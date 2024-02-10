package pastInterviews;

public class StringReversion {
    public static void main(String[] args) {
        String origin = "To be or not to be - that's the question";
        System.out.println(reverse1(origin));
        System.out.println(reverse2(origin));
        System.out.println(reverse3(origin));
        System.out.println(reverse4(origin));
    }

    /**
     * Just how you would do in reality, by Java lib
     * @param s
     * @return
     */
    private static String reverse1(String s) {
        return new StringBuffer(s).reverse().toString();
    }

    /**
     * Replace chars ordinarily
     * @param s
     * @return
     */
    private static String reverse2(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0, j = s.length() -1; i < j; i++, j--) {
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
        }
        return new String(chars);
    }

    /**
     * Replace chars using XOR.
     * So the XOR operation has a trait that having A and B:
     * 1. calculate X = A^B
     * 2. X^A will give you B (easily checked on 1-bit comparison for all possible combinations of 0, 1 values)
     * 3. X^B will give you A - conversely
     *
     * This way the two cells A and B are exchanged using three XOR operations
     *
     * @param s
     * @return
     */
    private static String reverse3(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0, j = s.length() -1; i < j; i++, j--) {
            chars[i] = (char) (chars[i] ^ chars[j]);
            chars[j] = (char) (chars[i] ^ chars[j]);
            chars[i] = (char) (chars[i] ^ chars[j]);
        }
        return new String(chars);

    }

    /**
     * Recursive
     * @param s
     * @return
     */
    private static String reverse4(String s) {
        if (s.length() == 0)
            return "";

        return reverse4(s.substring(1)) + s.charAt(0);
    }


}

