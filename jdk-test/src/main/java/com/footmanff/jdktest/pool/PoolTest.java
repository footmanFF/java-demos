package com.footmanff.jdktest.pool;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * Created by footmanff on 2017/5/26.
 */
public class PoolTest {

    /**
     * Creates a new {@code ThreadPoolExecutor} with the given initial
     * parameters and default thread factory.
     * <p>
     * param corePoolSize the number of threads to keep in the pool, even
     * if they are idle, unless {@code allowCoreThreadTimeOut} is set
     * param maximumPoolSize the maximum number of threads to allow in the
     * pool
     * param keepAliveTime when the number of threads is greater than
     * the core, this is the maximum time that excess idle threads
     * will wait for new tasks before terminating.
     * param unit the time unit for the {@code keepAliveTime} argument
     * param workQueue the queue to use for holding tasks before they are
     * executed.  This queue will hold only the {@code Runnable}
     * tasks submitted by the {@code execute} method.
     * param handler the handler to use when execution is blocked
     * because the thread bounds and queue capacities are reached
     *
     * @throws IllegalArgumentException if one of the following holds:<br>
     *                                  {@code corePoolSize < 0}<br>
     *                                  {@code keepAliveTime < 0}<br>
     *                                  {@code maximumPoolSize <= 0}<br>
     *                                  {@code maximumPoolSize < corePoolSize}
     * @throws NullPointerException     if {@code workQueue}
     *                                  or {@code handler} is null
     */
    @Test
    public void test() {
        ThreadPoolExecutor executorService = new ThreadPoolExecutor(5, 10,
                30L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue(10000),
                new ThreadPoolExecutor.CallerRunsPolicy());
        executorService.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                System.out.println("hello");
                return "hello";
            }
        });

    }

}
