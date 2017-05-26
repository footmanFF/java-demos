package com.fm.sqlite;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by zhangli on 2017/5/26.
 */
public class SqliteTest {

    @Test
    public void test() {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:/Users/zhangli/testsqlite.db");
            stmt = c.createStatement();
            String sql = "select * from COMPANY where `id`=1";
            ResultSet resultSet = stmt.executeQuery(sql);
            int count = resultSet.getMetaData().getColumnCount();
            while(resultSet.next()){
                for (int i = 1; i <= count; i++) {
                    System.out.println(resultSet.getString(i));
                }
            }
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

}
