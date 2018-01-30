package com.fm.groovy;

import groovy.lang.Binding;
import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import groovy.lang.Script;
import groovy.util.GroovyScriptEngine;
import org.codehaus.groovy.runtime.InvokerHelper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author footmanff on 2017/9/13.
 */
public class GroovyTest {

    private static String code = "class ttt {\n" +
            "\n" +
            "    public static void main(String[] args) {\n" +
            "        double a = 1000+100.0*99-(600-3*15)/(((68-9)-3)*2-100)+10000%7*71\n" +
            "        " +
            "    }\n" +
            "\n" +
            "}\n";

    public static void main(String[] args) throws Exception {
//        Resource resource = new ClassPathResource("groovy");
//        GroovyScriptEngine groovyScriptEngine = new GroovyScriptEngine(new String[]{resource.getFile().getAbsolutePath()});
//        groovyScriptEngine.run("ttt.groovy", new Binding());

        /*
        ExecutorService executorService = new ThreadPoolExecutor(5, 10,
                30L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1000),
                new ThreadPoolExecutor.DiscardPolicy());

        Binding binding = new Binding();
        GroovyClassLoader groovyClassLoader = new GroovyClassLoader();
        */


//        for (int i = 0; i < 10000000; i++) {
//             GroovyClassLoader groovyClassLoader = new GroovyClassLoader();
//            Map map = new HashMap();
//            map.put("i", i + "aa" + i + "sdsd" + i + System.currentTimeMillis() + code + code + code + code + code + code + code + code + code + code);
//            if(i % 10000 == 0){
//                gcInfo();
//            }
//        }

        code = "class ttt {\n" +
                "     int a = 0\n"  +
                "     int b = 0\n"  +
                "     String someMethod() {\n" +
                "        return a + b\n" +
                "    }\n" +
                "}\n";

        code = "class Testtt {\n" +
                "\n" +
                "    double a = 1000.1111\n" +
                "    double b = 100.0\n" +
                "    double c = 0.9999\n" +
                "\n" +
                "    Object someMethod() {\n" +
                "        return a+b*99-(600-3*15)/(((68-9)-3)*2-100)+10000%7*71*c\n" +
                "    }\n" +
                "\n" +
                "}";

        // String formula = "1000+100.0*99-(600-3*15)/(((68-9)-3)*2-100)+10000%7*71";
        GroovyClassLoader groovyClassLoader = new GroovyClassLoader();
        Class clazz = groovyClassLoader.parseClass(code);

        GroovyObject object = (GroovyObject) clazz.newInstance();
        object.setProperty("a", 1000.1111);
        object.setProperty("b", 100.0);
        object.setProperty("c", 0.9999);
        System.out.println(object.invokeMethod("someMethod", new Object[]{}));

        Binding aa = new Binding();
        aa.setProperty("a", 1);
        aa.setProperty("b", 3);
        Script ff = InvokerHelper.createScript(clazz, aa);
        Object value = ff.invokeMethod("someMethod", new Object[]{"aa"});
        System.out.println(value);

        long s = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            Binding binding = new Binding();
            //System.out.println("cost: " + (System.currentTimeMillis() - s));
            final Script script = InvokerHelper.createScript(clazz, new Binding());
            //System.out.println("cost: " + (System.currentTimeMillis() - s));
            script.run();
        }
        System.out.println("cost: " + (System.currentTimeMillis() - s));

//        int a = 0;

//        for (int i = 0; i < 100; i++) {
//            executorService.submit(new Runnable() {
//                @Override
//                public void run() {
//                    script.run();
//                }
//            });
//        }
//        System.out.println("xx");
    }

    private static void gcInfo(){
//        System.out.println(StringUtil.format("YGC: {} YGCT: {} FGC: {} FGCT: {}", getYoungGC(), getYoungGCTime(), getYoungGCTime(), getFullGCTime()));
    }

    public static long getYoungGC() {
        try {
            // java.lang:type=GarbageCollector,name=G1 Young Generation
            // java.lang:type=GarbageCollector,name=G1 Old Generation
            MBeanServer mbeanServer = ManagementFactory.getPlatformMBeanServer();
            ObjectName objectName;
            if (mbeanServer.isRegistered(new ObjectName("java.lang:type=GarbageCollector,name=ParNew"))) {
                objectName = new ObjectName("java.lang:type=GarbageCollector,name=ParNew");
            } else if (mbeanServer.isRegistered(new ObjectName("java.lang:type=GarbageCollector,name=Copy"))) {
                objectName = new ObjectName("java.lang:type=GarbageCollector,name=Copy");
            } else if (mbeanServer.isRegistered(new ObjectName("java.lang:type=GarbageCollector,name=G1 Young Generation"))) {
                objectName = new ObjectName("java.lang:type=GarbageCollector,name=G1 Young Generation");
            } else {
                objectName = new ObjectName("java.lang:type=GarbageCollector,name=PS Scavenge");
            }

            return (Long) mbeanServer.getAttribute(objectName, "CollectionCount");
        } catch (Exception e) {
            throw new RuntimeException("error");
        }
    }

    public static long getYoungGCTime() {
        try {
            MBeanServer mbeanServer = ManagementFactory.getPlatformMBeanServer();
            ObjectName objectName;
            if (mbeanServer.isRegistered(new ObjectName("java.lang:type=GarbageCollector,name=ParNew"))) {
                objectName = new ObjectName("java.lang:type=GarbageCollector,name=ParNew");
            } else if (mbeanServer.isRegistered(new ObjectName("java.lang:type=GarbageCollector,name=Copy"))) {
                objectName = new ObjectName("java.lang:type=GarbageCollector,name=Copy");
            } else if (mbeanServer.isRegistered(new ObjectName("java.lang:type=GarbageCollector,name=G1 Young Generation"))) {
                objectName = new ObjectName("java.lang:type=GarbageCollector,name=G1 Young Generation");
            } else {
                objectName = new ObjectName("java.lang:type=GarbageCollector,name=PS Scavenge");
            }

            return (Long) mbeanServer.getAttribute(objectName, "CollectionTime");
        } catch (Exception e) {
            throw new RuntimeException("error", e);
        }
    }

    public static long getFullGC() {
        try {
            MBeanServer mbeanServer = ManagementFactory.getPlatformMBeanServer();
            ObjectName objectName;

            if (mbeanServer.isRegistered(new ObjectName("java.lang:type=GarbageCollector,name=ConcurrentMarkSweep"))) {
                objectName = new ObjectName("java.lang:type=GarbageCollector,name=ConcurrentMarkSweep");
            } else if (mbeanServer.isRegistered(new ObjectName("java.lang:type=GarbageCollector,name=MarkSweepCompact"))) {
                objectName = new ObjectName("java.lang:type=GarbageCollector,name=MarkSweepCompact");
            } else if (mbeanServer.isRegistered(new ObjectName("java.lang:type=GarbageCollector,name=G1 Old Generation"))) {
                objectName = new ObjectName("java.lang:type=GarbageCollector,name=G1 Old Generation");
            } else {
                objectName = new ObjectName("java.lang:type=GarbageCollector,name=PS MarkSweep");
            }

            return (Long) mbeanServer.getAttribute(objectName, "CollectionCount");
        } catch (Exception e) {
            throw new RuntimeException("error");
        }
    }


    public static long getFullGCTime() {
        try {
            MBeanServer mbeanServer = ManagementFactory.getPlatformMBeanServer();
            ObjectName objectName;

            if (mbeanServer.isRegistered(new ObjectName("java.lang:type=GarbageCollector,name=ConcurrentMarkSweep"))) {
                objectName = new ObjectName("java.lang:type=GarbageCollector,name=ConcurrentMarkSweep");
            } else if (mbeanServer.isRegistered(new ObjectName("java.lang:type=GarbageCollector,name=MarkSweepCompact"))) {
                objectName = new ObjectName("java.lang:type=GarbageCollector,name=MarkSweepCompact");
            } else if (mbeanServer.isRegistered(new ObjectName("java.lang:type=GarbageCollector,name=G1 Old Generation"))) {
                objectName = new ObjectName("java.lang:type=GarbageCollector,name=G1 Old Generation");
            } else {
                objectName = new ObjectName("java.lang:type=GarbageCollector,name=PS MarkSweep");
            }

            return (Long) mbeanServer.getAttribute(objectName, "CollectionTime");
        } catch (Exception e) {
            throw new RuntimeException("error");
        }
    }

}
