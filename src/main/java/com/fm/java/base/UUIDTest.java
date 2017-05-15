package com.fm.java.base;

import com.querydsl.sql.MySQLTemplates;
import com.querydsl.sql.SQLExceptionTranslator;
import com.querydsl.sql.SQLQueryFactory;
import com.querydsl.sql.SQLTemplates;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;
import static org.jooq.impl.DSL.*;

/**
 * Created by zhangli on 2017/5/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class UUIDTest {

    @Resource(name = "dataSource")
    private DataSource dataSource;

    @Test
    public void t(){
//        UUID uuid = UUID.randomUUID();
//        System.out.println(uuid.toString().replaceAll("-", ""));


        Object sql1 = select().from("T1").innerJoin("T3").on("T2.t1id=T1.id");
        System.out.println(sql1);

//        Restrictions.ge()

        select().from("");

        SQLTemplates templates = MySQLTemplates.builder().build();
        com.querydsl.sql.Configuration configuration = new com.querydsl.sql.Configuration(templates);
        configuration.setExceptionTranslator(new SQLExceptionTranslator() {
            @Override
            public RuntimeException translate(String s, List<Object> list, SQLException e) {
                return null;
            }

            @Override
            public RuntimeException translate(SQLException e) {
                return null;
            }
        });

        SQLQueryFactory queryFactory = new SQLQueryFactory(configuration, dataSource);
        // queryFactory.select("");

    }

}
