package com.fm.tool.btrace;

import com.sun.btrace.annotations.*;

import static com.sun.btrace.BTraceUtils.*;

/**
 * @author zhangli on 2017/12/2.
 */
@BTrace
public class Debug {

    @com.sun.btrace.annotations.Export
    static Long counter;

    @OnMethod(
            clazz = "com.fm.tool.btrace.BtraceCase",
            method = "add",
            location = @Location( Kind.RETURN )
    )
    public static void run(@Self Object self, int a, int b, @Return int result, @Duration long time) {
        println("paramter: a=" + a + ", b=" + b);
        println("cost time:  " + time);
        counter++;
    }

    @OnTimer( 1000 )
    public static void run() {
        println("execute count: " + counter);
    }

}
