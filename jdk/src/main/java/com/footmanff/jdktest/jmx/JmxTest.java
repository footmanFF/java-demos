package com.footmanff.jdktest.jmx;

import org.junit.Test;

import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.ObjectName;

/**
 * @author footmanff on 2017/10/1.
 */
public class JmxTest {

    @Test
    public void test() throws Exception {
        ServerImpl serverImpl = new ServerImpl();
        ServerMonitor serverMonitor = new ServerMonitor(serverImpl);
        MBeanServer mBeanServer = MBeanServerFactory.createMBeanServer();
        ObjectName objectName = new ObjectName("objectName:id=ServerMonitor1");
        mBeanServer.registerMBean(serverMonitor, objectName);
        Long upTime = (Long) mBeanServer.getAttribute(objectName, "UpTime");
        System.out.println(upTime);
    }

    public static class ServerImpl {
        public final long startTime;

        public ServerImpl() {
            startTime = System.currentTimeMillis();
        }
    }

    public interface ServerMonitorMBean {
        long getUpTime();
    }

    public static class ServerMonitor implements ServerMonitorMBean {
        private final ServerImpl target;

        public ServerMonitor(ServerImpl target) {
            this.target = target;
        }

        @Override
        public long getUpTime() {
            return System.currentTimeMillis() - target.startTime;
        }
    }

}
