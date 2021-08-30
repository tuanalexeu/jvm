package com.tuanalexeu.jdk11;

import java.util.Arrays;
import java.util.List;

public class NewCollectionsMethods {

    /**
     * The java.util.Collection interface contains a new default toArray method which takes an IntFunction argument.
     * This makes it easier to create an array of the right type from a collection.
     */
    public static void toArray() {
        List<String> sampleList = Arrays.asList("Java", "Groovy", "Kotlin");
        String[] sampleArr = sampleList.toArray(String[]::new);
    }

}
