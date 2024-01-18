package javaLanguage.privateconstructor;

import java.io.BufferedReader;
import java.rmi.server.UID;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * To make class effectively final - create private default constructor
 * and don't provide any other constructor
 *
 * Then extending class won't be able by any means to create an instance of your class
 *
 * To use this class you can implement a static factory method, that will call
 * your private constructor
 */
public class A {
    private int value;
    private String string;
    private List<String> list;

    /**
     * don't create this to make class non-extendable
     * @param value
     * @param string
     */
    public A(int value, String string, List<String> list) {
        this.value = value;
        this.string = string;
        this.list = new ArrayList<>(list);
    };

    private A() {
    }

    public int getValue() {
        return value;
    }

    public String getString() {
        BufferedReader reader = new BufferedReader(null);
        Collections.singleton(reader);

        Collections.singleton(reader);

        if (equals(true)) {
            System.out.println();
        }


        return string;
    }

    /** Note this would be safe method for immutable class
     * - it should return deep copy of container
     *
     * See if we can rewrite this getter in derive B
     * @return
     */
    public List<String> getList() {
        return new ArrayList<>(list);
    }
}


