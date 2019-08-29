package com.footmanff.codes.dtobuilder;

/**
 * @author footmanff on 2019-07-16.
 */
public class Action<C> {

    public static void main(String[] args) {

        Action<? extends Context> a1 = new Action<>();
        Action<SubContext> a2 = new Action<>();

        a(a1);

        a(a2);

        Step step = new Step();

        step.exec(a1);
        step.exec(a2);
    }

    public static void a(Action<? extends Context> a1) {
        
    }

}
