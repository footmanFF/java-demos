package com.fm.framework.elasticsearch;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Test;

import java.net.InetAddress;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangli on 2017/9/11.
 */
public class ClientTest {

    @Test
    public void queryTest() throws Exception {

        /**
         *   es.cluster.name=wdbd_uat
         es.cluster.host1=172.20.100.183
         es.cluster.host2=172.20.100.185
         es.cluster.host3=172.20.100.186
         es.clusterTransport.port=9300
         es_dataapi.indexs.collect=dataapi
         es.contacts.index.collect=user_contacts
         */

        Settings settings = Settings.builder()
                                    .put("cluster.name", "wdbd_uat")
                                    .put("client.transport.sniff", true) //1
                                    .put("client.transport.ignore_cluster_name", false)// 2
                                    .put("client.transport.ping_timeout", 120, TimeUnit.SECONDS)//3 设置超时时间
                                    .put("client.transport.sniff", true)
                                    .build();

        TransportClient client = new PreBuiltTransportClient(Settings.EMPTY)
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("172.20.100.183"), 9300))
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("172.20.100.185"), 9300))
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("172.20.100.186"), 9300));

        
    }

}
