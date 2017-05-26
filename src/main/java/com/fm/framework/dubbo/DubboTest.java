package com.fm.framework.dubbo;

import com.weidai.cf.rdc.api.UserInfoApi;
import com.weidai.cf.rdc.entity.FieldInfo;
import com.weidai.cf.rdc.entity.Result;
import com.weidai.cf.rdc.entity.UserBaseInfo;
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
        UserBaseInfo userBaseInfo = new UserBaseInfo();
        Result<FieldInfo> result = userInfoApi.getUserInfo(userBaseInfo);
        System.out.println("start");
        System.out.println(result.getData());
        System.out.println("finish");
    }

}
