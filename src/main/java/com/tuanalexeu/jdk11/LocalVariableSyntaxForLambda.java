package com.tuanalexeu.jdk11;

import lombok.NonNull;

public class LocalVariableSyntaxForLambda {

    /**
     * We can use the keyword 'var' instead of the actual type in lambda local variables
     */
    public static void syntaxForLambda() {
        // The main benefit of using 'var' is that modifiers can be applied to the local variables.
        FunInterface funInterface = (@NonNull var a, @NonNull var b) -> (2 * a) + b;

        // We can't achieve the same if we omit the type
        // Compilation error: Annotations are not allowed here
        // FunInterface funInterface1 = (@NonNull  a, @NonNull b) -> (2 * a) + b;
    }

    public static void main(String[] args) {
        syntaxForLambda();
    }

    public static interface FunInterface {
        int sum(Integer a, Integer b);
    }

}
