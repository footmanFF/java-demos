package com.fm.sqlite;

import org.junit.Test;
import org.sqlite.SQLiteDataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by zhangli on 2017/5/26.
 */
public class SqliteDataSourceTest {

    @Test
    public void test() {
        SQLiteDataSource ds = new SQLiteDataSource();

        ds.setUrl("jdbc:sqlite:/Users/zhangli/testsqlite.db");
        try (Connection conn = ds.getConnection()) {
            String sql = "SELECT * FROM COMPANY";
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(sql);
            int count = rs.getMetaData().getColumnCount();
            while(rs.next()){
                for (int i = 1; i <= count; i++) {
                    System.out.println(rs.getString(i));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
    }

}
