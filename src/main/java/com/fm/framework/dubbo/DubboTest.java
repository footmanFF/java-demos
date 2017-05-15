package com.fm.framework.dubbo;

import cn.com.weidai.rdc.api.UserInfoApi;
import cn.com.weidai.rdc.entity.api.UserInfoResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by zhangli on 2017/5/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:dubbo/dubbo.xml"})
public class DubboTest {

    @Autowired
    private UserInfoApi userInfoApi;

    @Test
    public void rdcApiTest(){
        UserInfoResult result = userInfoApi.getUserInfo(null);
        System.out.println("start");
        System.out.println(result.getResult());
        System.out.println("finish");
    }

}
