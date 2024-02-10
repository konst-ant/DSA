package pastInterviews;

import java.util.function.Function;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

/**
 * Given a string s, find the first non-repeated character using stream function
 *
 * Input : String = "EPAM anywhere solutions "
 * Output : P
 */
public class FirstNonRepeatedCharacter {


    /**
     * very beautiful solution here:
     * use LinkedHashMap, which has controlled order of EntrySet iteration (they will appear up in the order of insertions into the map). With the call of .entrySet() we will get map entries in order of their original insertions :)
     * @param str
     * @return
     */
    private static Character findFirst(String str){
        Character res=str.chars().mapToObj(i->Character.toLowerCase(Character.valueOf((char)i))).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting())).entrySet().stream().filter(entry->entry.getValue()==1L).map(entry->entry.getKey()).findFirst().get();
        return res;

    }

    public static void main(String[] args) {
        String str="EPAM anywhere solutions";
        FirstNonRepeatedCharacter firstNonRepeatedCharacter = new FirstNonRepeatedCharacter();
        System.out.print(firstNonRepeatedCharacter.findFirst(str));
    }
}
