package com.footmanff.dubbo;

import com.alibaba.dubbo.rpc.RpcContext;
import com.weidai.cf.third.api.base.Response;
import com.weidai.cf.third.api.huadao.HuadaoApi;
import com.weidai.cf.third.api.huadao.HuadaoCreditRequest;
import com.weidai.cf.third.api.huadao.HuadaoCreditResult;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author zhangli on 2018/1/4.
 */
@Configuration
@ComponentScan( basePackages = "com.footmanff.dubbo" )
@ImportResource( "classpath:dubbo.xml" )
@EnableAutoConfiguration
public class AppStarter {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(AppStarter.class, args);
        HuadaoApi huadaoApi = applicationContext.getBean(HuadaoApi.class);
        HuadaoCreditRequest request = new HuadaoCreditRequest();
        request.setCycle("24");
        request.setPhone("15558026791");
        request.setPlatform("0");
        request.setIdCard("3333333333333333");
        request.setAppKey("7bbdec72d9d7436fbca02ead7d840347");
        Response<HuadaoCreditResult> response = huadaoApi.credit(request);
        RpcContext context = RpcContext.getContext();
        
        System.out.println(response);
        response = huadaoApi.credit(request);
        System.out.println(response);
        response = huadaoApi.credit(request);
        System.out.println(response);
        response = huadaoApi.credit(request);
        System.out.println(response);
    }

}
