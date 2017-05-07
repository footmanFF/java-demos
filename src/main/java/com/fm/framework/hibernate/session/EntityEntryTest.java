package com.fm.framework.hibernate.session;

import com.fm.framework.base.Employees;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhangli on 2017/5/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class EntityEntryTest {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    /**
     * 查询数据时的heap dump测试
     * @throws Exception
     */
    @Test
    public void sessionTest() throws Exception{
        List list = new ArrayList();
        while (true) {
            List<Employees> employees = (List<Employees>)hibernateTemplate.find("from Employees");
//            for(Employees employee : employees){
//                hibernateTemplate.update(employee);
//            }
            list.add(employees);
            TimeUnit.MILLISECONDS.sleep(100L);
        }
    }

}
