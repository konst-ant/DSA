package crackingCodingInterview;

/**
 *
 * page 91
 *
 * Implement a method to perform basic string compression using the count of repeated characters.
 * For example the string "aabcccccaaa" would become a2b1c5a3.
 * If the compressed string would not become smaller than the original string,
 * your method should return the original string. You can assume the string has only uppercase and lowercase letters (a-z).
 *
 */

public class CompressString {
    public static void main(String[] args) {
        System.out.println(compress("aabcccccaaa"));
    }

    public static String compress(String str){
        int count = 1;
        String ans = "";
        for(int i=1; i<str.length();i++){
            if(str.charAt(i)==str.charAt(i-1)){
                count++;
            }else{
                ans = ans+str.charAt(i-1)+""+count;
                count = 1;
            }
        }
        ans = ans+str.charAt(str.length()-1)+count;
        if(ans.length()>str.length())
            return str;
        return ans;
    }

}
