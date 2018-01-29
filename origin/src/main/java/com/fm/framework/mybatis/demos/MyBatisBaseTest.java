package com.fm.framework.mybatis.demos;

import com.fm.framework.base.Employees;
import com.fm.framework.base.EmployeesMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import java.io.InputStream;

/**
 * Created by zhangli on 2017/5/2.
 */
public class MyBatisBaseTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void init() throws Exception{
        String resource = "mybatis/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void sqlSessionFactoryTest() throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            Employees employees = sqlSession.selectOne("com.fm.framework.base.Employees.getEmployees", 10001L);
            int a = 0;
        } finally {
            sqlSession.close();
        }

        sqlSession = sqlSessionFactory.openSession();
        EmployeesMapper mapper = sqlSession.getMapper(EmployeesMapper.class);
        try {
            Employees employees = mapper.getEmployees(10001L);
            int a = 0;
        } finally {
            sqlSession.close();
        }
    }

}
