package com.fm;

import javax.script.ScriptException;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;

import java.math.BigDecimal;

public class Test {

    public static void main(String[] args) throws ScriptException, InstantiationException, IllegalAccessException {
        // TODO Auto-generated method stub
        String formula = "1000+100.0*99-(600-3*15)/(((68-9)-3)*2-100)+10000%7*71";
        ;

//        String formulaClass = "class Calc { }";
        /*ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName("JavaScript");
		for(int i =0;i<100000;i++){

			engine.eval(formula);
		}*/
        String groovyScript = "class Calc{" +
                "public Object calc(String text){" +
                "return Eval.me(text);"
                + "}}";


        System.out.println(1000.1111+100.0*99-(600-3*15)/(((68-9)-3)*2-100)+10000%7*71*0.9999 / 3.0);

        System.out.println(100000000 / 3.0);

//        ClassLoader parent = Test.class.getClassLoader();
//        GroovyClassLoader loader = new GroovyClassLoader(parent);
//        Class groovyClass = loader.parseClass(groovyScript, "Calc.groovy");
//        GroovyObject groovyObject = (GroovyObject) groovyClass.newInstance();
//        for (int i = 0; i < 100; i++) {
//            long time = System.currentTimeMillis();
//            Object a = groovyObject.invokeMethod("calc", formula);
//            System.out.println(System.currentTimeMillis() - time);
//        }
//
//        BigDecimal b = new BigDecimal(1);
    }


}


