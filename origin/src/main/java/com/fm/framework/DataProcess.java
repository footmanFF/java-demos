package com.fm.framework;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author footmanff on 2019-08-19.
 */
@Slf4j
@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( locations = {"classpath:spring.xml"} )
public class DataProcess {

    @Resource
    private DruidDataSource dataSource;

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Test
    public void name() throws Exception {
        String sql = "select order_id, parent_order_id, promotion from `order` where promotion!='' and locate('2', JSON_EXTRACT(promotion, \"$.pds.*.pf\")) >0 and order_id=";

        ClassPathResource resource = new ClassPathResource("orderids");

        BufferedReader bufferedReader = new BufferedReader(new FileReader(resource.getFile()));

        String line = null;

        AtomicInteger count = new AtomicInteger();

        AtomicInteger toProcess = new AtomicInteger();

        ThreadPoolExecutor queryPool = new ThreadPoolExecutor(50, 50, 30L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(100), new ThreadPoolExecutor.CallerRunsPolicy());

        Set<Long> shopOrderIdSet = new HashSet<>(500);
        
        while ((line = bufferedReader.readLine()) != null) {
            String l = line;
            queryPool.submit(() -> {
                long start = System.currentTimeMillis();
                List<Map<String, Object>> list = jdbcTemplate.queryForList(sql + l);
                if (!list.isEmpty()) {
                    Map<String, Object> row = list.get(0);
                    System.out.println("orderId: " + row.get("order_id") + " parent_order_id: " + row.get("parent_order_id"));
                    toProcess.incrementAndGet();

                    Long shopOrderId = (Long)row.get("parent_order_id");
                    shopOrderIdSet.add(shopOrderId);
                }

                int c = count.incrementAndGet();
                if (c % 50 == 0) {
                    System.out.println(count + " processed " + (System.currentTimeMillis() - start));
                }
            });
        }

        System.out.println("toProcess: " + toProcess);

        System.out.println("shopOrderIdSet: " + shopOrderIdSet);

        System.out.println("shopOrderIdSetSeiz: " + shopOrderIdSet.size());

        bufferedReader.close();
    }

}
