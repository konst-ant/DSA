package javaLanguage;

import java.util.HashMap;

/**
 * This is to demonstrate contract between equals() and hashcode() in Java:
 *
 * If we call the m.get() with the same object: System.out.println(m.get(a1)); - we will get the object.
 *
 * However, if we are trying to call with different object semantically equal to a1, this object has a different hashcode(),
 * so it is not found in the map.
 *
 * To fix the bug you need to redefine Apple#hashcode() respectively, e. g.
 *
 * public int hashCode(){
 * 	    return this.color.hashCode();
 * }
 *
 */

public class EqualsAndHashcode {
    private String color;

    public EqualsAndHashcode(String color) {
        this.color = color;
    }

    public boolean equals(Object obj) {
        if(obj==null) return false;
        if (!(obj instanceof EqualsAndHashcode))
            return false;
        if (obj == this)
            return true;
        return color.equals(((EqualsAndHashcode) obj).color);
    }


    public static void main(String[] args) {
        EqualsAndHashcode a1 = new EqualsAndHashcode("green");
        EqualsAndHashcode a2 = new EqualsAndHashcode("red");

        //hashMap stores apple type and its quantity
        HashMap<EqualsAndHashcode, Integer> m = new HashMap<EqualsAndHashcode, Integer>();
        m.put(a1, 10);
        m.put(a2, 20);
        System.out.println(m.get(new EqualsAndHashcode("green")));
    }
}