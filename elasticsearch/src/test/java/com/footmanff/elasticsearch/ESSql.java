package com.footmanff.elasticsearch;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.ElasticSearchDruidDataSourceFactory;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author footmanff on 2019-08-26.
 */
public class ESSql {

    @Test
    public void testJDBC() throws Exception {
        String TEST_INDEX = "elasticsearch-sql_test_index";

        Properties properties = new Properties();
        properties.put("url", "jdbc:elasticsearch://127.0.0.1:9300/" + TEST_INDEX);
        DruidDataSource dds = (DruidDataSource) ElasticSearchDruidDataSourceFactory.createDataSource(properties);
        Connection connection = dds.getConnection();
        PreparedStatement ps = connection.prepareStatement("SELECT  gender,lastname,age from  " + TEST_INDEX + " where lastname='Heath'");
        ResultSet resultSet = ps.executeQuery();
        List<String> result = new ArrayList<>();
        while (resultSet.next()) {
            result.add(resultSet.getString("lastname") + "," + resultSet.getInt("age") + "," + resultSet.getString("gender"));
        }

        ps.close();
        connection.close();
        dds.close();

        System.out.println(result);
    }

    @Test
    public void testJDBCWithParameter() throws Exception {
        String TEST_INDEX_ACCOUNT = "test-index";

        Properties properties = new Properties();
        properties.put(DruidDataSourceFactory.PROP_URL, "jdbc:elasticsearch://127.0.0.1:9300/" + TEST_INDEX_ACCOUNT);
        properties.put(DruidDataSourceFactory.PROP_CONNECTIONPROPERTIES, "client.transport.ignore_cluster_name=true");

        DruidDataSource dds = (DruidDataSource) ElasticSearchDruidDataSourceFactory.createDataSource(properties);
        Connection connection = dds.getConnection();
        PreparedStatement ps = connection.prepareStatement("SELECT * from " + TEST_INDEX_ACCOUNT + " limit 11");

        ResultSet resultSet = ps.executeQuery();

        List<String> result = new ArrayList<>();
        while (resultSet.next()) {
            result.add(resultSet.getString("buyer_user_id"));
        }

        System.out.println(result);

        connection.close();
        ps.close();
        dds.close();
    }

}
