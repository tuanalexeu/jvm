package com.tuanalexeu;

/**
 * Sources:
 * <a href="https://www.java67.com/2016/08/difference-between-early-vs-late-binding-in-java.html">Java67</a>
 * <a href="http://www.geeksforgeeks.org/difference-between-early-and-late-binding-in-java/">GeeksForGeeks</a>
 */
public class Binding {

    /**
     * The binding which can be resolved at compile time by the compiler
     * is known as static or early binding. Binding of all the static,
     * private and final methods is done at compile-time.
     */
    public static void earlyBinding() {
        SuperClass superClass = new SuperClass();
        SuperClass subClass = new SubClass();
        superClass.earlyPrint();
        subClass.earlyPrint();
    }

    /**
     * In the late binding or dynamic binding, the compiler doesn’t decide the method to be called.
     * Overriding is a perfect example of dynamic binding.
     * In overriding both parent and child classes have the same method.
     */
    public static void lateBinding() {
        SuperClass superClass = new SuperClass();
        SubClass subClass = new SubClass();
        superClass.latePrint();
        subClass.latePrint();
    }

    public static void main(String[] args) {
        earlyBinding();
        lateBinding();
    }

    public static class SuperClass {

        static void earlyPrint() {
            System.out.println("Print in SuperClass");
        }

        void latePrint() {
            System.out.println("Print in SuperClass");
        }
    }

    public static class SubClass extends SuperClass {

        static void earlyPrint() {
            System.out.println("Print in SubClass");
        }

        @Override
        void latePrint() {
            System.out.println("Print in SubClass");
        }
    }


}
