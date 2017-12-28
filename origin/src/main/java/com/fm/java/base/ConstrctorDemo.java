package com.fm.java.base;

/**
 * Created by fm on 2017/3/27.
 */
public class ConstrctorDemo {

    public static void main(String[] args) {
        Husband husband = new Husband();
    }

    static class Person {
        Person(String name) {
            System.out.println("Person Constrctor-----" + name);
        }
    }

    static class Husband extends Person {
        Husband() {
            // super("chenssy") 被注释会编译不通过
            super("chenssy");
            System.out.println("Husband Constructor...");
        }
    }
}
