package javaLanguage.privateconstructor;

import java.util.Arrays;
import java.util.List;

public class B extends A {

    public B(int i, String s) {
        super(i, s, Arrays.asList("one", "tow"));
    }

//    public B() {
//
//    }

    /**
     * Note: can't override getter if state variables are private
     * - private fields and methods are not inherited!
     * @return
     */
    @Override
    public List<String> getList() {
        //return list;
        return null;
    }



}
