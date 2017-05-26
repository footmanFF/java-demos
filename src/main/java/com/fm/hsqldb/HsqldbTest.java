package com.fm.hsqldb;

import org.junit.Test;

import java.sql.*;
import java.sql.Connection;
import java.sql.Statement;

/**
 * Created by zhangli on 2017/5/24.
 */
public class HsqldbTest {

    static String createSql = "CREATE TABLE api_result_handle (\n" +
            "  id int(11) NOT NULL AUTO_INCREMENT,\n" +
            "  api_code varchar(50) NOT NULL,\n" +
            "  result varchar(30) DEFAULT NULL,\n" +
            "  handle_type tinyint(4) NOT NULL,\n" +
            "  handle_value varchar(30) DEFAULT NULL,\n" +
            "  before_id int(11) NOT NULL,\n" +
            "  return_to int(11) DEFAULT NULL,\n" +
            "  create_time datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,\n" +
            "  update_time datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,\n" +
            "  create_id varchar(30) DEFAULT NULL,\n" +
            "  update_id varchar(30) DEFAULT NULL,\n" +
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
        statement.execute("INSERT INTO api_result_handle (id, api_code, result, handle_type, handle_value, before_id, return_to, create_time, update_time, create_id, update_id)\n" +
                "VALUES\n" +
                "\t(26,'loan_apply','STRATEGY_REFUSE',1,'STRATEGY_REFUSE',23,NULL,'2017-04-10 11:19:34','2017-04-10 11:19:46',NULL,NULL);");

        resultSet = statement.executeQuery("select * from api_result_handle");

        int count = resultSet.getMetaData().getColumnCount();
        while (resultSet.next()){
            for (int i = 1; i <= count; i++) {
                String columnName = resultSet.getMetaData().getColumnName(i);
                String value = resultSet.getString(i);
                System.out.print(value + "  ");
            }
            System.out.println();
        }

        statement.close();
        connection.close();
    }


}
