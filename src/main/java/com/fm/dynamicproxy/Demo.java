package com.fm.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fm on 2017/4/3.
 */
public class Demo {

    public static void main(String[] args) {
        List list = new ArrayList();
        ListInvocationHandler listInvocationHandler = new ListInvocationHandler(list);
        List listProxy = (List) Proxy.newProxyInstance(
                list.getClass().getClassLoader(),
                list.getClass().getInterfaces(),
                listInvocationHandler);
        listProxy.add(1);
        listProxy.add(2);
        listProxy.add(3);
        System.out.println(listProxy.size());
    }

    static class ListInvocationHandler implements InvocationHandler {
        List target;

        public ListInvocationHandler(List target) {
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("call " + method.getName());
            Object obj = method.invoke(target, args);
            System.out.println("end " + method.getName());
            return obj;
        }
    }

}
