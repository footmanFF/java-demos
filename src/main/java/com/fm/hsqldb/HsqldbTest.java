package com.fm.hsqldb;

import org.junit.Test;

import java.sql.*;
import java.sql.Connection;
import java.sql.Statement;

/**
 * Created by zhangli on 2017/5/24.
 */
public class HsqldbTest {

    static String createSql = "CREATE TABLE rule_field (\n" +
            "  id int(11) NOT NULL AUTO_INCREMENT,\n" +
            "  `code` varchar(150) NOT NULL,\n" +
            "  PRIMARY KEY (id)\n" +
            ")";
    static Connection connection;

    @Test
    public void test() throws Exception {
        Class.forName("org.hsqldb.jdbcDriver");

        connection = DriverManager.getConnection("jdbc:hsqldb:mem:testdb;sql.syntax_mys=true", "sa", "");
        Statement statement = null;
        ResultSet resultSet = null;
        statement = connection.createStatement();
        statement.execute(createSql);
        statement.execute("insert into rule_field(id, `code`) values (10, '123')");
        resultSet = statement.executeQuery("select id, `code` from rule_field");

        while (resultSet.next()) {
            System.out.println(resultSet.getString("id") + " (" + resultSet.getString("code") + ")");
        }

        statement.close();
        connection.close();
    }


}
