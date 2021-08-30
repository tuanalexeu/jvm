package com.tuanalexeu.jdk11;

/**
 * Java 11 adds a few new methods to the String class: isBlank, lines, strip, stripLeading, stripTrailing, and repeat.
 * These methods can reduce the amount of boilerplate involved in manipulating string
 * objects, and save us from having to import libraries.
 */
public class NewStringMethods {

    /**
     * As the name suggests, the repeat() instance method repeats the string content.
     */
    public static void repeat() {
        System.out.println("[repeat] " + "Example".repeat(2));
    }

    /**
     * The strip() instance method returns a string with all leading and trailing whitespaces removed.
     * strip*() determines whether the character is whitespace or not based on Character.isWhitespace().
     * In other words, it is aware of Unicode whitespace characters.
     *
     * This is different from trim(), which defines space as any character that is less than or
     * equal to the Unicode space character (U+0020). If we use trim() in the
     * previous example, we will get a different result
     */
    public static void strip() {
        System.out.println("[strip] " + "\n\t  hello   \u2005".strip());
    }

    // Just to get the difference between strip and trip methods
    public static void trim() {
        System.out.println("[trim] " + "\n\t  hello   \u2005".trim());
    }

    /**
     * The isBlank() instance method returns true if the string is empty
     * or contains only whitespace. Otherwise, it returns false.
     */
    public static void isBlank() {
        System.out.println("[isBlank] " + "\n\t\u2005  ".isBlank());
    }

    /**
     * The lines() instance method returns a Stream of lines extracted from the string, separated by line terminators.
     */
    public static void lines() {
        String example = "Example\nstring\nof\nseveral\nlines";
        example.lines()
                .map(s -> "[lines] " + s)
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        repeat();
        strip();
        trim();
        isBlank();
        lines();
    }

}
